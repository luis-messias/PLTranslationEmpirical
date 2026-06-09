import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ProgressBar {
    private static final String BEFORE_BAR = "\r";
    private static final String AFTER_BAR = "\n";
    
    private char fillChar;
    private char emptyChar;
    private String barTemplate;
    private String infoSep;
    private boolean showEta;
    private Boolean showPercent;
    private boolean showPos;
    private java.util.function.Function<Object, Optional<String>> itemShowFunc;
    private String label = "";
    private Appendable file;
    private Boolean color;
    private int updateMinSteps = 1;
    private int width = 30;
    private boolean autoWidth;
    
    private long completedIntervals = 0;
    private double avgTimePerIteration = 0.0;
    private Object currentElement;
    private boolean isHidden;
    private String lastLine;
    private boolean finished = false;
    private int position = 0;
    private List<Double> timeHistory = new ArrayList<>();

    public ProgressBar(java.util.Iterable<Object> iterable, 
                      Integer length, char fillChar, char emptyChar,
                      String barTemplate, String infoSep, boolean showEta,
                      Boolean showPercent, boolean showPos,
                      java.util.function.Function<Object, Optional<String>> itemShowFunc,
                      String label, Appendable file) {
        this.fillChar = fillChar;
        this.emptyChar = emptyChar;
        this.barTemplate = barTemplate;
        this.infoSep = infoSep;
        this.showEta = showEta;
        this.showPercent = showPercent;
        this.showPos = showPos;
        this.itemShowFunc = itemShowFunc;
        this.label = label != null ? label : "";
        
        if (file == null) {
            file = System.out;
        } else if (!(file instanceof Appendable)) {
            try {
                file = new PrintWriter(new OutputStreamWriter(file, StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        this.file = file;
        this.color = color != null ? color : true;
        
        if (length == null && iterable instanceof java.util.Collection) {
            length = ((java.util.Collection<?>)iterable).size();
        } else if (length == null) {
            try {
                var iterator = iterable.iterator();
                while(iterator.hasNext()) {
                    iterator.next();
                    position++;
                }
                length = position;
            } catch (Exception e) {
                throw new RuntimeException("Cannot determine collection size", e);
            }
        }

        this.length = length != null ? length : 0;
        if (length == -1 || length < 0) {
            length = null;
        } else {
            position = 0;
        }
        
        this.avgTimePerIteration = calculateAverage();
    }

    private double calculateAverage() {
        return avgTimePerIteration > 0 ? avgTimePerIteration : 1.0 / (length != null && length > 0 ? length : 1);
    }

    public Object nextElement() throws InterruptedException, TimeoutException {
        if (!entered) {
            throw new IllegalStateException("You need to use progress bars in a with block.");
        }
        
        renderProgress();
        return iterator.next();
    }

    private java.util.Iterator<Object> getIterator() {
        entered = true;
        var it = iterable.iterator();
        while (it.hasNext()) {
            currentElement = it.next();
            
            if (!entered) {
                throw new IllegalStateException("You need to use progress bars in a with block.");
            }

            renderProgress();
            
            yield(currentElement);
            
            update(1, currentElement);
        }
        
        finish();
        renderFinish();
    }

    private void makeStep(int nSteps) {
        position += nSteps;
        
        if (length != null && position >= length) {
            finished = true;
        }

        long now = System.currentTimeMillis();
        double timeSinceLastUpdate = (now - lastUpdateTimeMs);
        
        if (timeSinceLastUpdate < 1000) { // Less than 1 second, skip ETA calculation
            return;
        }
        
        lastUpdateTimeMs = now;

        if (position > 0) {
            double stepTime = (now - startTimeMs) / position;
            avgTimePerIteration = calculateAverage();
            
            timeHistory.add(stepTime);
            while(timeHistory.size() > 6) {
                timeHistory.remove(0);
            }
        } else {
            avgTimePerIteration = (System.currentTimeMillis() - startTimeMs) / position;
        }

        etaKnown = length != null && !finished;
    }

    private void update(int nSteps, Object currentElement) {
        if (currentElement != null) {
            this.currentElement = currentElement;
        }

        completedIntervals += nSteps;

        if (completedIntervals >= updateMinSteps) {
            makeStep(completedIntervals);
            renderProgress();
            completedIntervals = 0;
        }
    }

    private void finish() {
        etaKnown = false;
        currentElement = null;
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        if (finished) {
            return "Completed";
        } else {
            StringBuilder sb = new StringBuilder();
            
            int barLength = length != null ? 
                Math.min((int)(pct * width), width - 1) : 0;

            for (int i = 0; i < barLength; i++) {
                sb.append(fillChar);
            }
            
            for (int i = barLength; i < width && !finished; i++) {
                sb.append(emptyChar);
            }

            return label + " [" + sb.toString() + "]";
        }
    }

    private double pct {
        if (finished) {
            return 1.0;
        } else if (length == null || length <= 0) {
            return position / Math.max(1, completedIntervals);
        } else {
            return Math.min(position / (double)(length), 1.0);
        }
    }

    private double eta() {
        if (length != null && !finished) {
            return avgTimePerIteration * (length - position);
        }
        return 0;
    }

    public void renderProgress() throws IOException {
        if (isHidden) {
            lastLine = label;
            echo(label, file, color != null ? color : true);
            return;
        }

        StringBuilder buf = new StringBuilder();
        
        int clearWidth = width;
        if (maxWidth != null && maxWidth < lineLength()) {
            maxWidht = lineLength();
        }

        buf.append(BEFORE_BAR);
        String progressLine = formatProgressLine();
        buf.append(progressLine);
        buf.append(" ".repeat(clearWidth - progressLine.length()));
        
        if (!progressLine.equals(lastLine)) {
            lastLine = progressLine;
            echo(buf.toString(), file, color != null ? color : true);
            ((Appendable)file).flush();
        }
    }

    private void renderFinish() throws IOException {
        if (isHidden) {
            return;
        }
        
        ((Appendable)file).append(AFTER_BAR);
        ((Appendable)file).flush();
    }

    public boolean isAutoWidth() {
        return autoWidth;
    }

    private int lineLength() throws IOException {
        String formatted = formatProgressLine();
        return new java.io.StringWriter(formatted).length();
    }

    private void echo(String text, Appendable file, Boolean color) throws IOException {
        if (color != null && color) {
            // ANSI escape codes would go here for colored output
        }
        ((Appendable)file).append(text);
    }

    public static class Builder<T> {
        private java.util.Iterable<T> iterable;
        private Integer length = null;
        private char fillChar = '=';
        private char emptyChar = ' ';
        private String barTemplate = "%(bar)s";
        private String infoSep = "  ";
        private boolean showEta = true;
        private Boolean showPercent = null;
        private boolean showPos = false;
        private java.util.function.Function<T, Optional<String>> itemShowFunc = null;
        private String label = "";
        private Appendable file = System.out;
        private Boolean color = true;
        private int updateMinSteps = 1;
        private int width = 30;

        public Builder<java.lang.Object> iterable(java.util.Iterable<T> iterable) {
            this.iterable = (Iterable<Object>)iterable;
            return this;
        }

        public Builder<java.lang.Object> length(int length) {
            this.length = length;
            return this;
        }

        public Builder<java.lang.Object> fillChar(char c) {
            this.fillChar = c;
            return this;
        }

        public Builder<java.lang.Object> emptyChar(char c) {
            this.emptyChar = c;
            return this;
        }

        public Builder<java.lang.Object> barTemplate(String template) {
            this.barTemplate = template;
            return this;
        }

        public Builder<java.lang.Object> infoSep(String sep) {
            this.infoSep = sep;
            return this;
        }

        public Builder<java.lang.Object> showEta(boolean b) {
            this.showEta = b;
            return this;
        }

        public Builder<java.lang.Object> showPercent(Boolean p) {
            this.showPercent = p;
            return this;
        }

        public Builder<java.lang.Object> showPos(boolean pos) {
            this.showPos = pos;
            return this;
        }

        public Builder<java.lang.Object> itemShowFunc(java.util.function.Function<T, Optional<String>> func) {
            this.itemShowFunc = func;
            return this;
        }

        public Builder<java.lang.Object> label(String l) {
            this.label = l != null ? l : "";
            return this;
        }

        public Builder<java.lang.Object> file(Appendable f) {
            this.file = f;
            return this;
        }

        public Builder<java.lang.Object> color(Boolean c) {
            this.color = c != null ? c : true;
            return this;
        }

        public Builder<java.lang.Object> updateMinSteps(int steps) {
            this.updateMinSteps = steps;
            return this;
        }

        public Builder<java.lang.Object> width(int w) {
            this.width = w;
            return this;
        }

        public ProgressBar build() {
            if (iterable == null && length == null) {
                throw new IllegalArgumentException("iterable or length is required");
            }
            
            var iterableObj = iterable != null ? 
                java.util.Collections.unmodifiableList(
                    ((java.util.List<?>)iterable).stream().map(o -> o.toString()).collect(java.util.stream.Collectors.toList())
                ) : (Iterable<Object>)(() -> {});

            return new ProgressBar(iterable, length, fillChar, emptyChar, barTemplate, infoSep, showEta, 
                                  showPercent, showPos, itemShowFunc != null ? itemShowFunc.apply(null) : "", label, file);
        }
    }

    private int position;
    private Integer length = 0;
    private long startTimeMs = System.currentTimeMillis();
    private long lastUpdateTimeMs = System.currentTimeMillis();
    private boolean entered = false;
    private boolean etaKnown = true;
    private int maxWidth = null;
    
    public ProgressBar(Iterable<Object> iterable, 
                      Integer length) {
        this.iterable = (java.util.Iterable<?>)iterable;
        if (length == -1 || length < 0) {
            try {
                var iterator = ((Collection<?>)iterable).iterator();
                while(iterator.hasNext()) {
                    position++;
                    iterator.next();
                }
                this.length = null; // Unknown size
            } catch (Exception e) {
                throw new RuntimeException("Cannot determine collection size", e);
            }
        } else if (length != null && length > 0) {
            this.length = length;
        }

        startTimeMs = System.currentTimeMillis();
    }

    private Iterable<Object> iterable;
}


class Pager {
    
    public static void pager(java.util.Iterable<String> generator, Boolean color) throws IOException {
        var stdout = getBestEncoding(System.out);
        
        if (stdout == null || !isatty()) {
            return _nullPaging(generator, color != null ? color : true);
        }

        String pagerCmd = System.getenv("PAGER");
        if (pagerCmd != null && !pagerCmd.isEmpty() && !"notepad".equals(pagerCmd)) {
            // Handle Windows or other platforms differently
            return _tempFilePager(generator, pagerCmd.trim(), color);
        }

        if ("dumb".equalsIgnoreCase(System.getenv("TERM")) || "emacs".equalsIgnoreCase(System.getenv("TERM"))) {
            return _nullPaging(generator, color != null ? color : true);
        }

        // Try to use 'less' or similar tools on Unix-like systems
        try {
            ProcessBuilder pb = new ProcessBuilder("more", "-");
            var process = pb.start();
            
            java.io.BufferedReader reader = new java.io.BufferedReader(
                new InputStreamReader(process.getInputStream(), stdout)
            );

            for (String line : generator) {
                if (!color || !line.contains("\u001b")) { // Simple ANSI check
                    System.out.print(line);
                } else {
                    var stripped = stripAnsi(line);
                    System.out.print(stripped);
                }
            }

        } catch (Exception e) {
            _nullPaging(generator, color != null ? color : true);
        } finally {
            // Cleanup any temp files if created
        }
    }

    private static String stripAnsi(String text) {
        return Pattern.compile("\u001b\\[[^m]*m").matcher(text).replaceAll("");
    }

    public static void _nullPaging(java.util.Iterable<String> generator, Boolean color) throws IOException {
        for (String line : generator) {
            if (!color || !line.contains("\u001b")) {
                System.out.print(line);
            } else {
                var stripped = stripAnsi(line);
                System.out.print(stripped);
            }
        }
    }

    public static void _tempFilePager(java.util.Iterable<String> generator, String cmd, Boolean color) throws IOException {
        java.io.File tempFile = File.createTempFile("pager-", ".txt");
        
        StringBuilder textBuilder = new StringBuilder();
        for (String line : generator) {
            if (!color || !line.contains("\u001b")) {
                textBuilder.append(line);
            } else {
                var stripped = stripAnsi(line);
                textBuilder.append(stripped);
            }
        }

        try (java.io.FileWriter writer = new java.io.FileWriter(tempFile)) {
            writer.write(textBuilder.toString());
            
            Process process = Runtime.getRuntime().exec(cmd + " \"" + tempFile.getAbsolutePath() + "\"");
            int exitCode = process.waitFor();
            
            if (exitCode != 0) {
                throw new IOException("Pager command failed with code: " + exitCode);
            }
        } finally {
            try {
                java.io.File.delete(tempFile);
            } catch (Exception e) {
                // Ignore cleanup errors
            }
        }
    }

    public static void _pipePager(java.util.Iterable<String> generator, String cmd, Boolean color) throws IOException {
        Process process = Runtime.getRuntime().exec(cmd + " < /dev/null");
        
        java.io.BufferedReader reader;
        try (var inputStreamReader = new InputStreamReader(process.getInputStream(), getBestEncoding(System.out))) {
            reader = new BufferedReader(inputStreamReader);
            
            for (String line : generator) {
                if (!color || !line.contains("\u001b")) {
                    var stripped = stripAnsi(line);
                    process.getOutputStream().write(stripped.getBytes());
                } else {
                    process.getOutputStream().write(line.getBytes());
                }
            }
        } finally {
            try {
                reader.close();
            } catch (IOException e) {}
            
            // Wait for pager to finish
            int exitCode = 0;
            while ((exitCode != -1)) {
                if (!process.isAlive()) break;
                
                process.destroy();
            }
        }
    }

    private static String getBestEncoding(java.io.OutputStream stream) throws IOException {
        // Simplified encoding detection for Java
        return StandardCharsets.UTF_8.name();
    }

    public static boolean isatty() {
        try {
            java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


class Editor {
    
    private String editor = null;
    private Map<String, String> env = new java.util.HashMap<>();
    private boolean requireSave = true;
    private String extension = ".txt";

    public Editor(String editor) {
        this.editor = editor != null ? editor : getSystemEditor();
    }

    public void setEnv(Map<String, String> environmentVariables) {
        if (environmentVariables != null) {
            env.putAll(environmentVariables);
        }
    }

    private String getSystemEditor() {
        // Check common editors in order of preference
        for (String key : new String[]{"VISUAL", "EDITOR"}) {
            var editor = System.getenv(key);
            if (editor != null && !editor.isEmpty()) {
                return editor;
            }
        }

        // Try to find available editors on the system
        try {
            Process process = Runtime.getRuntime().exec("which vim >/dev/null 2>&1");
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                return "vim";
            }

            // Try nano, then vi as fallbacks
        } catch (Exception e) {}

        return "vi";
    }

    public void editFile(String filename) throws IOException {
        String editor = getEditor();
        
        ProcessBuilder pb = new ProcessBuilder(editor + " \"" + filename.replace("\"", "") + "\"");
        if (!env.isEmpty()) {
            Map<String, String> envMap = System.getenv();
            for (var entry : env.entrySet()) {
                envMap.put(entry.getKey(), entry.getValue());
            }
            pb.environment().putAll(env);
        }

        Process process = pb.start();
        
        int exitCode;
        try {
            exitCode = process.waitFor(10, TimeUnit.MINUTES); // Timeout after 10 minutes
            
            if (exitCode != 0) {
                throw new IOException("Editor failed with code: " + exitCode);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            process.destroyForcibly();
            throw new RuntimeException("Edit interrupted", e);
        } finally {
            // Cleanup if needed
        }
    }

    public String edit(String text) throws IOException {
        java.io.File tempFile = File.createTempFile("editor-", extension.replace(".", ""));
        
        byte[] data;
        try (var writer = new OutputStreamWriter(tempFile, StandardCharsets.UTF_8)) {
            if (text != null && !text.isEmpty()) {
                // Ensure text ends with newline on Unix-like systems
                String normalizedText = text.endsWith("\n") ? text : text + "\n";
                
                data = normalizedText.getBytes(StandardCharsets.UTF_8);
                
                writer.write(normalizedText);
            } else if (text == null) {
                // Empty file case - write nothing or minimal content
                return "";
            }

        } catch (IOException e) {
            throw new IOException("Failed to create temp editor file", e);
        } finally {
            try {
                java.io.File.delete(tempFile);
            } catch (Exception ignored) {}
        }

        editFile(tempFile.getAbsolutePath());
        
        // Check if user saved changes by comparing timestamps
        long originalTimestamp = System.currentTimeMillis();
        
        return null; // Return modified content or null for no change
    }

    private String getEditor() {
        if (editor != null) {
            return editor;
        } else {
            var systemEnv = System.getenv("VISUAL");
            if (systemEnv == null || systemEnv.isEmpty()) {
                systemEnv = System.getenv("EDITOR");
            }

            // Fallback to default editors based on platform detection would go here
            
            return "vi";
        }
    }
}


class OpenUrlUtil {
    
    public static int open(String url, boolean wait, boolean locate) throws IOException {
        
        if (System.getProperty("os.name").contains("Mac")) { // Darwin/macOS
            var args = new String[]{"open"};
            
            if (wait) {
                args[1] = "-W";
            }

            if (locate) {
                args[args.length - 2] = "-R";
            }

            ProcessBuilder pb = new ProcessBuilder(args);
            var process = pb.start();
            
            try {
                return process.waitFor(30, TimeUnit.SECONDS); // Wait up to 30 seconds for macOS open command
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }

        } else if (System.getProperty("os.name").contains("Windows")) {
            
            String unquotedUrl = url.replace("\"", "");
            
            if (locate) {
                // Explorer select command for Windows file selection
                var args = "explorer /select," + unquotedUrl;
                
                ProcessBuilder pb = new ProcessBuilder(args);
                return runProcess(pb, 30);

            } else {
                String waitStr = "/WAIT";
                if (!wait) {
                    waitStr = ""; // Don't add WAIT flag for non-blocking open
                }
                
                var args = "start" + waitStr + " \"\" \"" + unquotedUrl;
                
                ProcessBuilder pb = new ProcessBuilder(args);
                return runProcess(pb, 30);

            }

        } else if (System.getProperty("os.name").contains("CYGWIN")) { // Cygwin environment
            
            String unquotedUrl = url.replace("\"", "");
            
            if (locate) {
                var args = "cygstart \"" + unquotedUrl;
                
                ProcessBuilder pb = new ProcessBuilder(args);
                return runProcess(pb, 30);

            } else {
                String waitStr = "-w";
                if (!wait) {
                    waitStr = ""; // Don't add WAIT flag for non-blocking open
                }
                
                var args = "cygstart" + waitStr + " \"" + unquotedUrl;
                
                ProcessBuilder pb = new ProcessBuilder(args);
                return runProcess(pb, 30);

            }

        } else { // Linux/Unix-like systems
            
            String urlToOpen = locate ? 
                java.nio.file.Paths.get(url).getParent().toString() : url;
            
            if (locate && !url.startsWith("file://")) {
                try {
                    var path = new File(url);
                    urlToOpen = path.getParentFile() != null ? path.getParentFile().getAbsolutePath() : ".";
                } catch (Exception e) {}
            }

            ProcessBuilder pb = new ProcessBuilder("xdg-open", urlToOpen);
            
            try {
                var process = pb.start();
                
                if (wait) {
                    return process.waitFor(30, TimeUnit.SECONDS); // Wait up to 30 seconds for xdg-open command
                } else {
                    return 0; // Return immediately without waiting
                }

            } catch (Exception e) {
                // If xdg-open fails and it's a URL, try webbrowser
                
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    
                    java.net.URI uri = new java.net.URL(url).toURI();
                    
                    ProcessBuilder pbBrowser = new ProcessBuilder(
                        "xdg-open", 
                        uri.toString() // Use the full URL for browser opening
                    );

                    try {
                        var process2 = pbBrowser.start();
                        
                        if (wait) {
                            return process2.waitFor(30, TimeUnit.SECONDS);
                        } else {
                            return 0;
                        }

                    } catch (Exception e2) {
                        // If all methods fail for web URLs
                        
                        try {
                            java.net.URI uri = new java.net.URL(url).toURI();
                            
                            ProcessBuilder pbBrowserWeb = new ProcessBuilder(
                                "xdg-open", 
                                uri.toString()
                            );

                            var process3 = pbBrowserWeb.start();
                            
                            if (wait) {
                                return process3.waitFor(60, TimeUnit.SECONDS); // Give browser more time for web URLs
                            } else {
                                return 0;
                            }

                        } catch (Exception e3) {
                            throw new IOException("Failed to open URL: " + url, e3);
                        }
                    }
                } else {
                    throw new IOException("xdg-open failed for file path", e);
                }
            } finally {}
        }

    }

    private static int runProcess(ProcessBuilder pb, long timeoutSeconds) throws InterruptedException {
        var process = pb.start();
        
        try {
            return process.waitFor(timeoutSeconds, TimeUnit.SECONDS);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            process.destroyForcibly();
            return -1; // Indicate interruption
            
        } finally {}
    }

}


class TerminalInput {
    
    public static String getchar(boolean echo) throws IOException, InterruptedException {
        
        if (!isatty(System.in)) {
            throw new IllegalStateException("stdin is not a terminal");
        }

        var oldSettings = getTerminalAttributes(); // Save current settings
        
        try (var ttyStream = openRawTerminal()) {
            
            byte[] buffer = new byte[32];
            int bytesRead;
            
            while ((bytesRead = System.in.read(buffer)) > 0) {
                String input = new String(buffer, 0, bytesRead);

                if (!echo || !isatty(System.out)) {
                    // Don't echo on non-tty output or when explicitly disabled
                    
                } else {
                    System.out.print(input);
                    System.out.flush();
                }

                return processInput(input);
            }

        } finally {
            restoreTerminalAttributes(oldSettings);
        }
    }

    private static boolean isatty(java.io.InputStream stream) throws IOException {
        // Simplified tty check for Java - in real implementation would use /proc/self/fd/0 or similar
        
        try (var process = Runtime.getRuntime().exec("tty")) {
            var exitCode = process.waitFor();
            
            return exitCode == 0;

        } catch (Exception e) {
            // Assume not a tty if we can't check
            
            return false;
        }
    }

    private static java.io.InputStream openRawTerminal() throws IOException, InterruptedException {
        
        var process = Runtime.getRuntime().exec("stty -a >/dev/null 2>&1");
        
        try (var inputStreamReader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8)) {
            return System.in; // Return stdin for raw reading
            
        } catch (Exception e) {
            throw new IOException("Failed to open terminal", e);

        } finally {}
    }

    private static void restoreTerminalAttributes(Map<String, Object> oldSettings) throws IOException {
        
        try (var process = Runtime.getRuntime().exec("stty sane")) {
            
        } catch (Exception ignored) {} // Ignore errors in restoring settings
        
    }

    public static Map<String, Object> getTerminalAttributes() {
        
        var attributes = new java.util.HashMap<String, Object>();
        
        try (var process = Runtime.getRuntime().exec("stty -a")) {
            
            String output;
            try (var reader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8)) {
                output = reader.read();

            } catch (IOException e) {} else if (!output.isEmpty()) {
                
                // Parse stty output to extract terminal settings
                
            } finally {}
            
        } catch (Exception ignored) {}
        
        return attributes;
    }

    private static String processInput(String input) throws IOException, InterruptedException {
        
        char ch = input.charAt(0);
        
        if (ch == '\u0003') { // Ctrl+C - interrupt signal
            
            throw new java.util.concurrent.InterruptedException();

        } else if (ch == '\u0004' && !System.getProperty("os.name").contains("Windows")) {
            
            throw new EOFError();

        } else if (ch == '\u001a' && System.getProperty("os.name").contains("Windows")) {
            
            throw new EOFError();

        } else {
            
            return input; // Return the character as-is
            
        }
    }

}


class ClickException extends Exception {
    
    private String message;
    private Object cause = null;

    public ClickException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        
        if (cause != null && !(cause instanceof java.lang.Throwable)) {
            return message + ": " + cause.toString();
            
        } else {
            return message;
        }
    }

}


class EOFError extends Exception {
    
    private static final long serialVersionUID = 1L;

    public EOFError() {}

    @Override
    public String getMessage() {
        
        return "EOF"; // End of file error
        
    }
}