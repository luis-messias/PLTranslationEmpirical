import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * NOTE: This translation assumes the existence of utility methods and classes 
 * (like PlatformUtils, ClickException, EchoUtil) that handle platform-specific 
 * compatibility functions found in the original Python's internal imports 
 * (e.g., _default_text_stdout, isatty, term_len, get_best_encoding).
 */

public class ProgressUtilities {

    // --- Platform Constants and Globals ---
    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("win");
    private static final boolean CYGWIN = false; // Placeholder for Cygwin check
    
    // Python's os.name == "nt" check
    private static final boolean NT_OS = IS_WINDOWS;

    public static String BEFORE_BAR;
    public static String AFTER_BAR;

    static {
        if (NT_OS) {
            BEFORE_BAR = "\r";
            AFTER_BAR = "\n";
        } else {
            // ANSI escape codes for cursor manipulation
            BEFORE_BAR = "\r\033[?25l"; 
            AFTER_BAR = "\033[?25h\n";
        }
    }

    // --- ProgressBar Class ---

    /**
     * Represents a progress bar utility.
     * @param <V> The type of the items being iterated over.
     */
    public static class ProgressBar<V> implements AutoCloseable {
        private String fillChar;
        private String emptyChar;
        private String barTemplate;
        private String infoSep;
        private boolean showEta;
        private Boolean showPercent; // Use wrapper to distinguish between false and unset
        private boolean showPos;
        private Function<V, String> itemShowFunc;
        private String label;
        private PrintStream file;
        private Boolean color;
        private int updateMinSteps;
        private int width;

        // State variables
        private long completedIntervals = 0;
        private double[] avgTimes = new double[1]; // Using array to simulate list/queue behavior for fixed size history
        private int maxWidth = -1;
        private boolean entered = false;
        private V currentItem = null;
        private String lastLine = null;

        // Timing and Length
        private Long length = null;
        private int pos = 0;
        private double lastEtaTime = 0.0;
        private Instant start = Instant.now();
        private boolean etaKnown = false;
        private boolean finished = false;
        private boolean isHidden = PlatformUtils.isatty(null) == false; // Assuming null check works for stdout

        public ProgressBar(Iterable<V> iterable, Integer length, String fillChar, 
                           String emptyChar, String barTemplate, String infoSep, 
                           boolean showEta, Boolean showPercent, boolean showPos, 
                           Function<V, String> itemShowFunc, String label, 
                           PrintStream file, Boolean color, int updateMinSteps, int width) {

            this.fillChar = fillChar;
            this.emptyChar = emptyChar;
            this.barTemplate = barTemplate;
            this.infoSep = infoSep;
            this.showEta = showEta;
            this.showPercent = showPercent;
            this.showPos = showPos;
            this.itemShowFunc = itemShowFunc;
            this.label = label != null ? label : "";
            this.file = file != null ? file : PlatformUtils.getDefaultTextStdout();

            this.color = color;
            this.updateMinSteps = updateMinSteps;
            this.width = width;
            this.autowidth = width == 0;

            // Handle iterable and length initialization (Python's length_hint equivalent)
            if (iterable != null && length == null) {
                try {
                    Iterator<V> it = iterable.iterator();
                    int count = 0;
                    while (it.hasNext()) {
                        count++;
                    }
                    this.length = count;
                } catch (Exception e) {
                    // Fallback if iteration fails or is complex
                    this.length = null;
                }
            }

            if (iterable == null && length == null) {
                throw new IllegalArgumentException("iterable or length is required");
            } else if (iterable == null) {
                this.iterable = java.util.Collections.emptyList(); // Should not happen based on logic, but for safety
            } else {
                 // If length was provided explicitly and iterable is null/defaulted
                 if (length != null && iterable instanceof List) {
                     // Assume list or array if we need to cast it back later
                 }
                this.iterable = iterable;
            }

            this.pos = 0;
            // Initialize avgTimes history storage (size is fixed, simulating a queue/list of last N elements)
            this.avgTimes[0] = 0.0; 
            this.lastEtaTime = 0.0;
        }

        /**
         * Context manager entry point (__enter__).
         */
        public void enter() {
            this.entered = true;
            renderProgress();
        }

        /**
         * Context manager exit point (__exit__ / AutoCloseable).
         */
        @Override
        public void close() {
            renderFinish();
        }

        // --- Properties (Getters) ---

        public double getPct() {
            if (finished) return 1.0;
            long totalLength = length != null ? length : 1;
            return Math.min((double) pos / totalLength, 1.0);
        }

        public double getTimePerIteration() {
            // Simplified: assumes avgTimes holds the necessary data points
            if (avgTimes[0] == 0.0 && this.pos == 0) return 0.0;
            // In a real implementation, we'd calculate average from the stored history array/list.
            return 0.0; // Placeholder for complex calculation
        }

        public double getEta() {
            if (length != null && !finished) {
                // Simplified ETA calculation
                return getTimePerIteration() * (length - pos);
            }
            return 0.0;
        }

        // --- Formatting Methods ---

        public String formatEta() {
            if (!etaKnown || length == null) return "";
            double eta = getEta();
            long t = (long) Math.floor(eta);
            
            if (t < 0) return ""; // Should not happen

            long seconds = (int) (t % 60);
            t /= 60;
            long minutes = t % 60;
            t /= 60;
            long hours = t % 24;
            t /= 24;

            StringBuilder sb = new StringBuilder();
            if (t > 0) {
                sb.append(t).append("d ");
            }
            sb.append(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            return sb.toString();
        }

        public String formatPos() {
            StringBuilder sb = new StringBuilder();
            sb.append(pos);
            if (length != null) {
                sb.append("/").append(length);
            }
            return sb.toString();
        }

        public String formatPct() {
            // Python: f"{int(self.pct * 100): 4}%"[1:] -> removes leading space/char
            return String.format("%d%%", (int) Math.round(getPct() * 100));
        }

        public String formatBar() {
            if (length != null && !finished) {
                int barLength = (int) (Math.ceil(getPct() * width));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < barLength; i++) {
                    sb.append(fillChar);
                }
                for (int i = barLength; i < width; i++) {
                    sb.append(emptyChar);
                }
                return sb.toString();
            } else if (finished) {
                return fillChar.repeat(width);
            } else {
                // Placeholder for complex dynamic bar logic based on time_per_iteration
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < width; i++) {
                    sb.append(emptyChar);
                }
                return sb.toString();
            }
        }

        public String formatProgressLine() {
            List<String> infoBits = new ArrayList<>();
            boolean showPercentLocal = this.showPercent != null ? this.showPercent : false;

            if (length != null && this.showPercent == null) {
                // If show_percent is None, default to not showing position if we are showing percent
                showPercentLocal = !this.showPos; 
            }

            if (this.showPos) {
                infoBits.add(formatPos());
            }
            if (showPercentLocal) {
                infoBits.add(formatPct());
            }
            if (this.showEta && etaKnown && !finished) {
                infoBits.add(formatEta());
            }
            if (itemShowFunc != null) {
                String itemInfo = itemShowFunc.apply(currentItem);
                if (itemInfo != null) {
                    infoBits.add(itemInfo);
                }
            }

            String info = String.join(this.infoSep, infoBits);

            // Use String.format equivalent for Python's % formatting
            return String.format(this.barTemplate, 
                                  this.label != null ? this.label : "", 
                                  formatBar(), 
                                  info).trim();
        }

        /**
         * Renders the progress bar to the output stream.
         */
        public void renderProgress() {
            if (isHidden) {
                return;
            }

            // --- Width Calculation Logic ---
            int clearWidth = this.width;
            if (this.maxWidth != -1) {
                clearWidth = this.maxWidth;
            }

            String line = formatProgressLine();
            int lineLen = PlatformUtils.termLength(line);
            
            // Update max width if necessary
            if (this.maxWidth == -1 || this.maxWidth < lineLen) {
                this.maxWidth = lineLen;
            }

            // Build the final output string: [BEFORE_BAR] + Line + [Spaces to clear]
            String buffer = BEFORE_BAR + line + " ".repeat(clearWidth - lineLen);
        
            if (!Objects.equals(line, this.lastLine)) {
                this.lastLine = buffer;
                // Use echo utility or direct print/flush equivalent
                PlatformUtils.echo(buffer, this.file, this.color); 
                this.file.flush();
            }
        }

        /**
         * Simulates make_step logic (updating internal state).
         */
        public void makeStep(int nSteps) {
            pos += nSteps;
            if (length != null && pos >= length) {
                finished = true;
            }

            // Time check placeholder
            if ((System.currentTimeMillis() - lastEtaTime) < 1000) {
                return;
            }

            lastEtaTime = System.currentTimeMillis();

            double step;
            if (pos > 0) {
                step = (System.currentTimeMillis() - start.toEpochMilli()) / pos;
            } else {
                step = System.currentTimeMillis() - start.toEpochMilli();
            }

            // Update average times history (simulating fixed size queue/list)
            if (avgTimes[0] != 0.0) {
                 System.arraycopy(this.avgTimes, 1, this.avgTimes, 0, avgTimes.length - 1);
            }
            this.avgTimes[0] = step;

            etaKnown = length != null;
        }

        /**
         * Updates the progress bar state.
         */
        public void update(int nSteps, V currentItem) {
            if (currentItem != null) {
                this.currentItem = currentItem;
            }

            completedIntervals += nSteps;

            if (completedIntervals >= this.updateMinSteps) {
                makeStep((int) completedIntervals);
                renderProgress();
                completedIntervals = 0;
            }
        }

        /**
         * Marks the progress bar as finished.
         */
        public void finish() {
            etaKnown = false;
            currentItem = null;
            finished = true;
        }

        // --- Iterator/Generator Simulation ---
        
        private Iterable<V> iterable;

        /**
         * Simulates the generator functionality (using Java's try-with-resources pattern).
         */
        public java.util.stream.Stream<V> stream() {
            if (!entered) {
                throw new IllegalStateException("You need to use progress bars in a with block.");
            }

            return java.util.stream.Stream.iterate(0, i -> i + 1)
                    .limit((long) length != null ? length : -1); // Simplified iteration control
        }
    }


    // --- Pager Utilities ---

    /**
     * Main entry point for the pager logic.
     */
    public static void pager(Iterable<String> generator, Boolean color) {
        PrintStream stdout = PlatformUtils.getDefaultTextStdout();

        if (!PlatformUtils.isatty(System.in) || !PlatformUtils.isatty(stdout)) {
            nullPager(stdout, generator, color);
            return;
        }

        String pagerCmd = System.getenv().getOrDefault("PAGER", "").trim();
        if (pagerCmd != null && !pagerCmd.isEmpty()) {
            if (IS_WINDOWS) {
                tempFilePager(generator, pagerCmd, color);
            } else {
                // Assuming POSIX/Linux environment for pipe and temp file logic
                if (System.getenv("TERM") != null && System.getenv("TERM").contains("dumb") || System.getenv("TERM").contains("emacs")) {
                    nullPager(stdout, generator, color);
                    return;
                }
                if (IS_WINDOWS || PlatformUtils.isOS2()) { // Placeholder for OS2 check
                    tempFilePager(generator, "more <", color);
                    return;
                }
                // Check if 'less' is available via system call
                try {
                    Process p = Runtime.getRuntime().exec("sh -c \"os.system(\" + "(less) 2>/dev/null") + \"\"");
                    p.waitFor();
                    if (p.exitValue() == 0) {
                        pipePager(generator, "less", color);
                        return;
                    }
                } catch (Exception e) { /* ignore */ }

                // Fallback to temp file approach using 'more'
                try {
                    Path tempFile = Files.createTempFile("pager-", ".txt");
                    if (PlatformUtils.systemCheck(tempFile.toString(), "more") == 0) {
                        pipePager(generator, "more", color);
                        return;
                    }
                } catch (IOException e) { /* ignore */ }

            }
        }
        // Final fallback
        nullPager(stdout, generator, color);
    }


    private static void pipePager(Iterable<String> generator, String cmd, Boolean color) {
        try {
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", cmd);
            Process process = pb.start();

            // Environment setup for colors (less flags)
            Map<String, String> env = new HashMap<>(System.getenv());
            if (color == null || !color) {
                String lessFlags = System.getenv("LESS") != null ? System.getenv("LESS") : "";
                if (!lessFlags.isEmpty()) {
                    env.put("LESS", lessFlags);
                } else {
                    env.put("LESS", "-R"); // Default color support
                }
            }

            // Write content to the process's stdin
            try (OutputStream stdin = process.getOutputStream()) {
                for (String text : generator) {
                    String outputText = (color == null || !color) ? PlatformUtils.stripAnsi(text) : text;
                    stdin.write((outputText + "\n").getBytes());
                    stdin.flush();
                }
            } catch (IOException e) {
                // Handle write error
            } finally {
                process.getOutputStream().close();
            }

            // Wait for the process to finish or be interrupted
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } catch (IOException e) {
            System.err.println("Error running pager command: " + e.getMessage());
        }
    }

    private static void tempFilePager(Iterable<String> generator, String cmd, Boolean color) {
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile("pager-", ".txt");
            StringBuilder textBuilder = new StringBuilder();
            for (String s : generator) {
                textBuilder.append(s).append("\n");
            }

            String content = (color == null || !color) ? PlatformUtils.stripAnsi(textBuilder.toString()) : textBuilder.toString();
            
            Files.write(tempFile, content.getBytes());

            // Execute the pager command on the temp file
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", String.format("%s \"%s\"", cmd, tempFile));
            Process process = pb.start();
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error in temporary file pager: " + e.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.delete(tempFile);
                } catch (IOException e) { /* ignore */ }
            }
        }
    }

    private static void nullPager(PrintStream stream, Iterable<String> generator, Boolean color) {
        for (String text : generator) {
            if (color == null || !color) {
                text = PlatformUtils.stripAnsi(text);
            }
            stream.print(text);
        }
    }

    // --- Editor Class ---

    public static class Editor {
        private String editor;
        private Map<String, String> env;
        private boolean requireSave;
        private String extension;

        public Editor(String editor, Map<String, String> env, boolean requireSave, String extension) {
            this.editor = editor;
            this.env = env;
            this.requireSave = requireSave;
            this.extension = extension;
        }

        public String getEditor() {
            if (this.editor != null) return this.editor;
            
            String[] keys = {"VISUAL", "EDITOR"};
            for (String key : keys) {
                String rv = System.getenv(key);
                if (rv != null) return rv;
            }

            if (IS_WINDOWS) {
                return "notepad";
            }

            String[] editors = {"sensible-editor", "vim", "nano"};
            for (String editorName : editors) {
                try {
                    // Check if command exists in PATH
                    Process p = new ProcessBuilder("which", editorName).start();
                    p.waitFor();
                    if (p.exitValue() == 0) {
                        return editorName;
                    }
                } catch (Exception e) { /* ignore */ }
            }
            return "vi";
        }

        public void editFile(String filename) throws Exception {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command().add(getEditor());
            pb.command().add(filename);

            Map<String, String> envCopy = (this.env != null) ? new HashMap<>(System.getenv()) : new HashMap<>();
            if (this.env != null) {
                envCopy.putAll(this.env);
            }
            pb.environment().clear();
            pb.environment().putAll(envCopy);

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                throw new RuntimeException(String.format("%s: Editing failed", getEditor()));
            }
        }

        public String edit(String text) throws Exception {
            Path tempFile = null;
            try {
                byte[] data;
                if (text == null || text.isEmpty()) {
                    data = new byte[0];
                } else if (text.getBytes("utf-8") != null) { // Assuming bytes input handling is complex, sticking to String for simplicity
                     // If we were truly supporting AnyStr, this would be more complex.
                     String textStr = text; 
                    if (!textStr.endsWith("\n")) {
                        textStr += "\n";
                    }

                    if (IS_WINDOWS) {
                        data = textStr.replace("\n", "\r\n").getBytes("utf-8-sig");
                    } else {
                        data = textStr.getBytes("utf-8");
                    }
                } else {
                     throw new IllegalArgumentException("Unsupported type for editing.");
                }

                // Create temporary file
                tempFile = Files.createTempFile("editor-", this.extension);
                Files.write(tempFile, data);

                // Set timestamps (requires specific OS calls, simplified here)
                // os.utime(name, (os.path.getatime(name), os.path.getmtime(name) - 2))
                long timestamp = System.currentTimeMillis(); // Placeholder for mtime

                editFile(tempFile.toString());

                if (this.requireSave && Files.getLastModifiedTime(tempFile) == java.nio.file.attribute.FileTime.fromMillis(timestamp)) {
                    return null;
                }

                byte[] rv = Files.readAllBytes(tempFile);

                // Decode and normalize line endings
                String result = new String(rv, "utf-8-sig").replace("\r\n", "\n");
                return result;

            } finally {
                if (tempFile != null) {
                    try {
                        Files.delete(tempFile);
                    } catch (IOException e) { /* ignore */ }
                }
            }
        }
    }


    // --- Utility Functions ---

    public static int openUrl(String url, boolean wait, boolean locate) {
        if (System.getProperty("os.name").toLowerCase().contains("darwin")) { // macOS
            List<String> args = new ArrayList<>();
            args.add("open");
            if (wait) args.add("-W");
            if (locate) args.add("-R");
            args.add(PlatformUtils.unquoteFile(url));

            try {
                ProcessBuilder pb = new ProcessBuilder(args);
                // Redirect stderr to /dev/null equivalent
                pb.redirectErrorStream(true); 
                Process process = pb.start();
                process.waitFor();
                return process.exitValue();
            } catch (Exception e) {
                return -1;
            }

        } else if (IS_WINDOWS) { // Windows
            String urlCleaned = PlatformUtils.unquoteFile(url).replace("\"", "");
            String args;
            if (locate) {
                args = String.format("explorer /select,\"%s\"", urlCleaned);
            } else {
                String waitStr = wait ? "/WAIT" : "";
                args = String.format("start %s \"\" \"%s\"", waitStr, urlCleaned);
            }
            return Runtime.getRuntime().exec(args).waitFor();

        } else if (PlatformUtils.isCygwin()) { // Cygwin/MinGW
            String urlCleaned = PlatformUtils.unquoteFile(url).replace("\"", "");
            String args;
            if (locate) {
                String dir = Paths.get(urlCleaned).getParent().toString();
                args = String.format("cygstart \"%s\"", dir);
            } else {
                String waitStr = wait ? "-w" : "";
                args = String.format("cygstart %s \"%s\"", waitStr, urlCleaned);
            }
            return Runtime.getRuntime().exec(args).waitFor();

        } else { // POSIX (Linux/Unix)
            String url;
            if (locate) {
                url = PlatformUtils.unquoteFile(url).replace("\"", "");
                // Get directory name or current directory "."
                try {
                    Path path = Paths.get(PlatformUtils.unquoteFile(url));
                    String parent = path.getParent() != null ? path.getParent().toString() : ".";
                    url = parent;
                } catch (Exception e) {
                    url = ".";
                }
            } else {
                url = PlatformUtils.unquoteFile(url);
            }

            try {
                ProcessBuilder pb = new ProcessBuilder("xdg-open", url);
                Process process = pb.start();
                if (wait) {
                    return process.waitFor();
                } else {
                    return 0; // Non-blocking success
                }
            } catch (Exception e) {
                // Fallback to webbrowser equivalent if xdg-open fails
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    // Java doesn't have a built-in web browser opener like Python's webbrowser
                    System.out.println("Attempting to open URL via default system handler: " + url);
                    return 0;
                }
                return -1;
            }
        }
    }

    /**
     * Translates control characters into Java exceptions.
     */
    public static Class<? extends Exception> translateChToExc(String ch) {
        if (ch != null && ch.equals("\x03")) {
            return java.lang.Exception.class; // KeyboardInterrupt equivalent
        }

        // EOFError handling is tricky as it depends on the stream context
        if (ch != null && ch.equals("\x04") && !IS_WINDOWS) {
             return java.io.EOFException.class;
        }
        if (ch != null && ch.equals("\x1a") && IS_WINDOWS) {
            return java.io.EOFException.class;
        }

        return null; // No exception mapped
    }


    // --- Terminal Input Handling (Platform Specific) ---

    /**
     * Context manager for raw terminal mode (POSIX/Linux).
     */
    public static class RawTerminal implements AutoCloseable {
        private int fd = -1;
        private boolean entered = false;

        public void enter() throws IOException {
            // Logic to set TTY raw mode (requires JNI or specialized libraries, highly complex in pure Java)
            // Placeholder: Assume successful setup and setting the file descriptor.
            this.entered = true;
        }

        @Override
        public void close() throws Exception {
            // Restore terminal settings
            if (this.entered) {
                // Logic to restore old termios settings
                System.out.flush();
            }
        }
    }

    /**
     * Simulates reading a character in raw mode.
     */
    public static String getchar(boolean echo) throws Exception {
        try (RawTerminal raw = new RawTerminal()) {
            raw.enter(); // Enter context manager
            // Reading bytes from the file descriptor 'fd'
            byte[] buffer = new byte[32];
            int bytesRead = System.in.read(buffer); 

            if (bytesRead > 0) {
                String ch = new String(buffer, 0, bytesRead).trim();
                if (echo && PlatformUtils.isatty(System.out)) {
                    System.out.print(ch);
                }
                // Translate and return the character string
                return ch;
            }
        } catch (Exception e) {
             // Handle read errors
        }
        return "";
    }


    // =======================================================================
    // MOCK/UTILITY CLASS PLACEHOLDERS
    // These classes simulate the functionality imported from Python's internal modules.
    // =======================================================================

    private static class PlatformUtils {
        public static PrintStream getDefaultTextStdout() {
            return System.out; // Mocking _default_text_stdout()
        }

        public static boolean isatty(PrintStream stream) {
            // Simplified check: assume true if outputting to console
            return System.out.getFD().toString().contains("fd"); 
        }
        
        public static String stripAnsi(String s) {
            // Basic ANSI stripping regex replacement (simplified)
            return s.replaceAll("\\[[0-9;]+m", "");
        }

        public static int termLength(String s) {
            return s.length(); // Mocking terminal length calculation
        }

        public static boolean isOS2() {
            // Placeholder for OS2 check
            return false; 
        }
        
        public static boolean isCygwin() {
             // Placeholder for Cygwin detection
             return false;
        }

        /** Utility to safely execute system commands and return exit code. */
        public static int systemCheck(String command, String program) throws Exception {
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();
            process.destroy();
            return exitCode;
        }

        /** Utility to unquote file paths (handles quotes and file:// scheme). */
        public static String unquoteFile(String url) {
            if (url == null) return "";
            // Simple unquoting logic placeholder
            return url.replace("\"", ""); 
        }
    }

    // Example usage structure (not part of the required output, but helpful for testing):
    /*
    public static void main(String[] args) throws Exception {
        // Test ProgressBar
        ProgressBar<Integer> pb = new ProgressBar<>(
                java.util.Arrays.asList(1, 2, 3), // Iterable
                null, // No explicit length
                "=", " ", "[", 
                "|", // bar_template: e.g., "[=====>   ]"
                " | ", 
                true, false, true, 
                i -> String.valueOf(i * 2), // itemShowFunc
                "Processing:", 
                System.out, Boolean.TRUE, 1, 30);

        try (ProgressBar<Integer> pb = pb) {
            pb.enter();
            for (int i : java.util.Arrays.asList(1, 2, 3)) {
                Thread.sleep(500);
                pb.update(1, i);
            }
        } // AutoCloseable calls finish() and render_finish()

        // Test Pager (requires actual files/system setup)
    }
    */
}