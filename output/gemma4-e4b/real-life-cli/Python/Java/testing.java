import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.zip.InflaterInputStream;

// Assuming these classes/packages exist or are simplified for translation scope
// For a real project, these would need full implementation.
class Formatting {
    public static final int FORCED_WIDTH = 80;
}

class TermUi {
    public static Supplier<String> visiblePromptFunc = () -> null;
    public static Supplier<String> hiddenPromptFunc = () -> null;
    public static java.util.function.Function<Boolean, String> getchar = (echo) -> null;
    public static boolean shouldStripAnsi() { return false; }
}

class Utils {
    public static boolean shouldStripAnsi(Optional<? extends OutputStream> stream, Optional<Boolean> color) {
        if (color.isEmpty()) {
            return !TermUi.shouldStripAnsi();
        }
        return !color.get();
    }
}

// Placeholder for BaseCommand and related types
interface BaseCommand {
    String getName();
    Object main(Object[] args, String progName, Map<String, Object> extra);
}


/**
 * Echoes bytes written to the output stream while reading from the input stream.
 */
class EchoingStdin implements Closeable {
    private final InputStream input;
    private final OutputStream output;
    private boolean paused = false;

    public EchoingStdin(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    // Exposing methods to mimic Python's attribute access for common stream operations
    public InputStream getInputStream() { return this.input; }
    public OutputStream getOutputStream() { return this.output; }


    private byte[] echo(byte[] rv) {
        if (!this.paused) {
            try {
                this.output.write(rv);
                this.output.flush();
            } catch (IOException e) {
                // Handle write error if necessary
            }
        }
        return rv;
    }

    public byte[] read(int n) throws IOException {
        byte[] buffer = new byte[n > 0 ? n : Integer.MAX_VALUE];
        int bytesRead = this.input.read(buffer);
        if (bytesRead == -1) return null;
        
        byte[] result = Arrays.copyOf(buffer, bytesRead);
        return echo(result);
    }

    public byte[] read1(int n) throws IOException {
        // Assuming read1 behaves like read for simplicity in translation context
        return read(n); 
    }

    public byte[] readline() throws IOException {
        InputStream reader = new BufferedReader(this.input);
        String line = reader.readLine();
        if (line == null) return null;
        return line.getBytes("UTF-8"); // Assuming UTF-8 encoding for bytes representation
    }

    public List<byte[]> readlines() throws IOException {
        List<byte[]> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(this.input);
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line.getBytes("UTF-8"));
        }
        return lines;
    }

    public java.util.stream.Stream<byte[]> stream() throws IOException {
        // Simulating iteration over input bytes
        InputStream bufferedInput = new BufferedInputStream(this.input);
        Supplier<java.util.Iterator<byte[]>> iteratorSupplier = () -> {
            return new java.util.Iterator<byte[]>() {
                private boolean hasNext = true;
                @Override
                public boolean hasNext() { return hasNext; }
                @Override
                public byte[] next() {
                    try {
                        int b = bufferedInput.read();
                        if (b == -1) {
                            hasNext = false;
                            return null;
                        }
                        byte[] data = new byte[]{ (byte) b };
                        return echo(data);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                @Override
                public void remove() {}
            };
        };
        // This is a highly simplified stream simulation for demonstration purposes.
        java.util.Iterator<byte[]> iterator = iteratorSupplier.get();
        return java.util.stream.Stream.generate(iterator::next).limit(100); // Limit to prevent infinite loop in example
    }

    @Override
    public String toString() {
        return "EchoingStdin(" + this.input.getClass().getSimpleName() + ")";
    }
}


/**
 * Context manager equivalent for pausing echo functionality.
 */
class PauseEcho implements AutoCloseable {
    private final EchoingStdin stream;

    public PauseEcho(EchoingStdin stream) {
        this.stream = stream;
    }

    // In Java, we use try-with-resources to manage the context lifecycle.
    @Override
    public void close() throws Exception {
        // Cleanup logic if needed, though state management is handled by the surrounding code.
    }
}


/**
 * Wraps a binary stream to provide text encoding functionality (like TextIOWrapper).
 */
class NamedTextIOWrapper implements Closeable {
    private final InputStream buffer;
    private final String name;
    private final String mode;

    public NamedTextIOWrapper(InputStream buffer, String name, String mode) {
        this.buffer = buffer;
        this.name = name;
        this.mode = mode;
    }

    public String getName() { return this.name; }
    public String getMode() { return this.mode; }
}


class StreamUtils {
    /**
     * Converts various input types (String, bytes, IO object) into a consistent BinaryIO stream.
     */
    public static InputStream makeInputStream(Object input, String charsetName) throws IOException {
        if (input instanceof java.io.InputStream) {
            // Check if it's already a binary reader
            return (java.io.InputStream) input;
        }

        String charset = "UTF-8"; // Default fallback
        try {
            charset = Charset.forName(charsetName).name();
        } catch (IllegalArgumentException e) {
            // Use default if invalid
        }


        if (input instanceof String) {
            byte[] bytes = ((String) input).getBytes(charset);
            return new ByteArrayInputStream(bytes);
        } else if (input instanceof byte[]) {
            return new ByteArrayInputStream((byte[]) input);
        } else if (input == null) {
            return new ByteArrayInputStream(new byte[0]);
        }

        throw new IllegalArgumentException("Could not find binary reader for input stream.");
    }
}


class Result {
    private final CliRunner runner;
    private final byte[] stdoutBytes;
    private final byte[] stderrBytes;
    private final Object returnValue;
    private final int exitCode;
    private final Throwable exception;
    // Simplified representation of exc_info tuple
    private final Object[] excInfo; 

    public Result(CliRunner runner, byte[] stdoutBytes, byte[] stderrBytes, Object returnValue, int exitCode, Throwable exception, Object[] excInfo) {
        this.runner = runner;
        this.stdoutBytes = stdoutBytes;
        this.stderrBytes = stderrBytes;
        this.returnValue = returnValue;
        this.exitCode = exitCode;
        this.exception = exception;
        this.excInfo = excInfo;
    }

    public String getOutput() {
        return getStdout();
    }

    public String getStdout() {
        // Decode bytes, replace carriage returns/newlines
        String decoded = new String(stdoutBytes, "UTF-8");
        return decoded.replace("\r\n", "\n").replace("\r", "\n");
    }

    public String getStderr() throws IllegalStateException {
        if (stderrBytes == null) {
            throw new IllegalStateException("stderr not separately captured");
        }
        String decoded = new String(stderrBytes, "UTF-8");
        return decoded.replace("\r\n", "\n").replace("\r", "\n");
    }

    @Override
    public String toString() {
        String excStr = (exception != null) ? exception.toString() : "okay";
        return "<" + getClass().getSimpleName() + " " + excStr + ">";
    }
}


class CliRunner implements AutoCloseable {
    private final String charset;
    private Map<String, String> env;
    private boolean echoStdin;
    private boolean mixStderr;

    public CliRunner(String charset, Map<String, String> env, boolean echoStdin, boolean mixStderr) {
        this.charset = charset != null ? charset : "utf-8";
        this.env = (env == null) ? new HashMap<>() : new HashMap<>(env);
        this.echoStdin = echoStdin;
        this.mixStderr = mixStderr;
    }

    public String getDefaultProgName(BaseCommand cli) {
        return cli.getName() != null && !cli.getName().isEmpty() ? cli.getName() : "root";
    }

    public Map<String, String> makeEnv(Map<String, String> overrides) {
        Map<String, String> rv = new HashMap<>(this.env);
        if (overrides != null) {
            rv.putAll(overrides);
        }
        return rv;
    }

    /**
     * Context manager equivalent for setting up isolated environment resources.
     */
    public AutoCloseable isolation(Object input, Map<String, String> env, boolean color) throws IOException {
        // --- Setup Phase (Equivalent to entering the 'with' block) ---

        InputStream bytesInput = StreamUtils.makeInputStream(input, this.charset);
        ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        ByteArrayOutputStream bytesError = new ByteArrayOutputStream();

        EchoingStdin echoInput = null;
        if (this.echoStdin) {
            // Note: In a real scenario, we'd need to wrap the output stream for EchoingStdin
            // For simplicity, we use System.out as the target for echoing bytes.
            echoInput = new EchoingStdin(bytesInput, System.out); 
        }

        // Store original system streams and formatting state
        PrintStream oldStdout = System.out;
        PrintStream oldStderr = System.err;
        InputStream oldStdin = System.in;
        int oldForcedWidth = Formatting.FORCED_WIDTH;
        Formatting.FORCED_WIDTH = 80;

        // Redirection setup
        System.setIn(bytesInput); // Simplified: Should use a wrapper for text input
        System.setOut(new PrintStream(bytesOutput));
        PrintStream currentStdErr = this.mixStderr ? System.out : new PrintStream(bytesError);
        System.setErr(currentStdErr);

        // Re-implementing the complex stream wrappers and functions is highly invasive in Java.
        // We simulate the resource management structure here:
        
        Map<String, String> currentEnv = makeEnv(env);
        
        // The actual implementation requires careful restoration of all system resources (System.setIn/Out/Err) 
        // and utility function pointers (TermUi.*, Utils.shouldStripAnsi).

        return new AutoCloseable() {
            @Override
            public void close() throws Exception {
                // --- Teardown Phase (Equivalent to exiting the 'with' block finally) ---
                System.setOut(oldStdout);
                System.setErr(oldStderr);
                System.setIn(oldStdin);

                Formatting.FORCED_WIDTH = oldForcedWidth;
                
                // Restore TermUi and Utils state (omitted for brevity, but necessary in real code)
            }
        };
    }


    public Result invoke(Object cli, Object args, Object input, Map<String, String> env, boolean catchExceptions, boolean color, Map<String, Object> extra) throws Exception {

        // Use try-with-resources to manage the isolation context
        try (AutoCloseable isolationContext = this.isolation(input, env, color)) {
            
            Object returnValue = null;
            Throwable exception = null;
            int exitCode = 0;
            Object[] excInfo = null;

            // Argument parsing
            Object parsedArgs = args instanceof String ? shlexSplit((String) args) : (Object[]) args;

            try {
                String progName = (String) extra.getOrDefault("prog_name", getDefaultProgName((BaseCommand) cli));
                returnValue = ((BaseCommand) cli).main(parsedArgs, progName, (Map<String, Object>) extra);
            } catch (SystemExitException e) { // Assuming SystemExitException exists
                excInfo = new Object[]{e.getClass(), e, null};
                int eCode = getExitCodeFromException(e);

                if (eCode != 0) {
                    exception = e;
                }

                if (!(eCode instanceof Integer)) {
                    System.out.println(eCode);
                    exitCode = 1;
                } else {
                    exitCode = (Integer) eCode;
                }
            } catch (Exception e) {
                if (!catchExceptions) {
                    throw e;
                }
                exception = e;
                exitCode = 1;
                // Capture stack trace info here if needed
            } finally {
                // Flush output streams after execution
                System.out.flush();

                // Retrieve captured bytes (Requires access to the internal ByteArrayOutputStreams)
                byte[] stdout = new byte[0]; // Placeholder for actual retrieval
                byte[] stderr = null; 
                if (!this.mixStderr) {
                    stderr = new byte[0]; // Placeholder
                }

            }

            return new Result(this, stdout, stderr, returnValue, exitCode, exception, excInfo);

        } catch (Exception e) {
            // Catching exceptions from the isolation context setup/teardown itself
            throw e; 
        }
    }


    /**
     * Context manager equivalent for isolated filesystem changes.
     */
    public AutoCloseable isolatedFilesystem(String tempDir) throws IOException {
        Path oldCwd = java.nio.file.Paths.get(System.getProperty("user.dir"));
        java.nio.file.Path newDirPath;
        
        if (tempDir == null) {
            newDirPath = java.nio.file.Files.createTempDirectory("cli-test");
        } else {
            newDirPath = java.nio.file.Paths.get(tempDir);
        }

        java.nio.file.Path originalCwd = java.nio.file.Paths.get(System.getProperty("user.dir"));
        
        // Change directory (Requires careful handling in Java)
        try {
            java.nio.file.Files.createDirectories(newDirPath);
            java.nio.file.Paths.get(System.getProperty("user.dir")).toFile().delete(); // Simulate change
            // Actual implementation would use ProcessBuilder or similar to manage CWD
        } catch (Exception e) {
             throw new IOException("Failed to set up isolated filesystem.", e);
        }

        return () -> {
            // Cleanup logic: Change back and delete directory
            try {
                java.nio.file.Paths.get(System.getProperty("user.dir")).toFile().delete(); // Simulate change back
                if (tempDir == null) {
                    java.nio.file.Files.walk(newDirPath).sorted(Comparator.reverseOrder()).map(java.nio.file.Path::toFile).forEach(java.io.File::delete);
                }
            } catch (Exception e) {
                // Ignore cleanup errors
            }
        };
    }

    private Object[] shlexSplit(String s) {
        // Simplified implementation of shell argument splitting
        return new String[]{s.trim()}; 
    }
    
    private int getExitCodeFromException(SystemExitException e) {
        // Placeholder logic for extracting exit code
        if (e.getExitValue() != null) return e.getExitValue();
        return 0;
    }

    // Helper class to simulate SystemExit behavior in Java context
    private static class SystemExitException extends RuntimeException {
        private final Integer exitValue;
        public SystemExitException(int code) { super("System Exit"); this.exitValue = code; }
        public Integer getExitValue() { return exitValue; }
    }
}