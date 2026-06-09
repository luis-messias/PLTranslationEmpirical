import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class mimicking the stream handling logic of the original Python module.
 * Note: Due to fundamental differences between Python's dynamic I/O model and Java's strict typing,
 * some complex behaviors (like automatic stream wrapping or platform-specific console hacks)
 * are translated conceptually rather than literally.
 */
public class StreamUtils {

    // --- Constants and Static Fields ---

    private static final Pattern ANSI_RE = Pattern.compile("\u001b\\[[;?0-9]*[a-zA-Z]");

    // Placeholder for platform detection logic (simplified)
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    // --- Core Stream Wrappers and Helpers ---

    /**
     * Mimics the _NonClosingTextIOWrapper functionality, ensuring that closing the wrapper
     * does not close the underlying stream if it's used for non-closing operations.
     */
    private static class NonClosingTextIOWrapper extends TextOutputStreamWrapper {
        private final OutputStream underlyingStream;

        public NonClosingTextIOWrapper(InputStream underlyingStream, String encoding, String errors) throws IOException {
            super(underlyingStream, encoding, errors);
            this.underlyingStream = underlyingStream;
        }

        @Override
        public void close() throws IOException {
            // Do not close the underlying stream (mimics non-closing behavior)
            // The caller is responsible for closing the original source stream.
        }
    }

    /**
     * Mimics _FixupStream, acting as a proxy to handle read/write operations on an underlying stream.
     */
    private static class FixupStream {
        private final InputStream delegate;
        private final boolean forceReadable;
        private final boolean forceWritable;

        public FixupStream(InputStream stream, boolean forceReadable, boolean forceWritable) {
            this.delegate = stream;
            this.forceReadable = forceReadable;
            this.forceWritable = forceWritable;
        }

        // Delegation for basic methods (read, write, etc.)
        public int read(byte[] b, int off, int len) throws IOException {
            if (forceReadable || delegate != null) {
                return delegate.read(b, off, len);
            }
            throw new UnsupportedOperationException("Reading not supported.");
        }

        public void write(int b) throws IOException {
            if (forceWritable && delegate != null) {
                delegate.write(b);
            }
        }
        // ... other method delegations would be needed for full fidelity, but we focus on core I/O methods used later.
    }

    /**
     * Helper class to manage stream encoding and conversion logic.
     */
    private static class StreamConverter {
        public static String getBestEncoding(InputStream stream) {
            // Simplified: In Python, it checks the stream's attribute or default encoding.
            // In Java, we rely on system defaults or explicit configuration.
            return System.getProperty("file.encoding", "UTF-8");
        }

        public static boolean isAsciiEncoding(String encoding) {
            if (encoding == null) return false;
            try {
                Charset charset = Charset.forName(encoding);
                // A simple check: if it supports only ASCII range characters, we treat it as ASCII-like for this context.
                return charset.isValid(new byte[]{(byte) 0x7F}); // Check a common non-ASCII character boundary
            } catch (java.nio.charset.UnsupportedCharsetException e) {
                return false;
            }
        }

        /**
         * Creates the appropriate TextIO wrapper stream.
         */
        public static Reader makeTextStream(InputStream rawStream, String encoding, String errors, boolean forceReadable, boolean forceWritable) throws IOException {
            if (encoding == null) {
                encoding = getBestEncoding(rawStream);
            }
            // Java's InputStreamReader handles the conversion.
            return new InputStreamReader(rawStream, Charset.forName(encoding));
        }
    }

    /**
     * Mimics stream type checking (binary vs text).
     */
    private static boolean isBinaryReader(InputStream stream) {
        try {
            // Attempt to read a byte and check if it's bytes data.
            byte[] buffer = new byte[1];
            int result = stream.read(buffer);
            if (result > 0) return true;
            return false;
        } catch (IOException e) {
            return false;
        } finally {
            // Rewind or reset the stream state if possible, though this is unreliable in Java streams.
        }
    }

    private static boolean isBinaryWriter(OutputStream stream) {
        try {
            stream.write(new byte[]{}); // Attempt to write bytes
            return true;
        } catch (IOException e) {
            // If writing fails, it might be a text-only stream.
            return false;
        }
    }

    /**
     * Finds the underlying binary stream if the provided stream is text-oriented.
     */
    private static InputStream findBinaryReader(InputStream stream) {
        if (isBinaryReader(stream)) {
            return stream;
        }
        // Java streams generally don't expose a 'buffer' attribute like Python file objects do.
        // This logic is highly platform-specific and often requires reflection or specific library knowledge.
        // We skip the buffer check for standard Java implementation safety.
        return null;
    }

    private static OutputStream findBinaryWriter(OutputStream stream) {
        if (isBinaryWriter(stream)) {
            return stream;
        }
        return null;
    }


    /**
     * Forces the provided stream to be correctly wrapped for text reading/writing.
     */
    public static Reader forceCorrectTextReader(InputStream rawStream, String encoding, String errors, boolean forceReadable) throws IOException {
        // Simplified logic: Assume if we are forcing a reader, we use the converter.
        return StreamConverter.makeTextStream(rawStream, encoding, errors, forceReadable, false);
    }

    public static Writer forceCorrectTextWriter(OutputStream rawStream, String encoding, String errors, boolean forceWritable) throws IOException {
        // Simplified logic: Assume if we are forcing a writer, we use the converter.
        return new OutputStreamWriter(rawStream, Charset.forName(encoding));
    }

    /**
     * Gets binary streams for standard I/O.
     */
    public static InputStream getBinaryStdin() {
        // In Java, System.in is typically an InputStream (binary).
        return System.in;
    }

    public static OutputStream getBinaryStdout() {
        // System.out is typically a PrintStream wrapping an OutputStream.
        return System.out;
    }

    public static OutputStream getBinaryStderr() {
        return System.err;
    }

    /**
     * Gets text streams for standard I/O, handling platform differences.
     */
    public static Reader getTextStdin(String encoding, String errors) throws IOException {
        // Use the force correct reader logic
        return forceCorrectTextReader(System.in, encoding, errors, true);
    }

    public static Writer getTextStdout(String encoding, String errors) throws IOException {
        // Use the force correct writer logic
        return forceCorrectTextWriter(System.out, encoding, errors, true);
    }

    public static Writer getTextStderr(String encoding, String errors) throws IOException {
        return forceCorrectTextWriter(System.err, encoding, errors, true);
    }


    // --- Atomic File Handling (NIO.2 equivalent) ---

    /**
     * Wraps file opening logic to handle atomic writes using temporary files.
     */
    public static Pair<OutputStream, Boolean> openStream(String filename, String mode, String encoding, String errors, boolean atomic) throws IOException {
        boolean isBinary = mode.contains("b");

        if (atomic && !isBinary) {
            // Atomic write logic requires complex NIO operations in Java
            Path realPath = Paths.get(filename);
            String tempFilename = filename + ".tmp"; // Simplified temporary naming

            try {
                // 1. Open the temporary file with required flags
                FileChannel channel = FileChannel.open(Paths.get(tempFilename), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

                // 2. Wrap and write to the temp file (simulated)
                OutputStream os = new BufferedOutputStream(channel.asOutputStream());

                // 3. If successful, return a wrapper that handles renaming on close/exit
                AtomicFile atomicFile = new AtomicFile(os, Paths.get(tempFilename), realPath);
                return new Pair<>(atomicFile, true);

            } catch (IOException e) {
                throw e;
            }
        } else if (isBinary) {
            // Standard binary open
            FileOutputStream fos = new FileOutputStream(filename, mode.contains("a") ? true : false);
            return new Pair<>(fos, false);
        } else {
            // Standard text open
            Writer writer = new BufferedWriter(new OutputStreamWriter(System.out, Charset.forName(encoding))); // Placeholder for actual file writing
            return new Pair<>(writer, false);
        }
    }

    /**
     * Mimics the AtomicFile context manager and resource management.
     */
    private static class AtomicFile implements Closeable {
        private OutputStream underlyingStream;
        private Path tempPath;
        private Path realPath;
        private boolean closed = false;

        public AtomicFile(OutputStream stream, Path tempPath, Path realPath) {
            this.underlyingStream = stream;
            this.tempPath = tempPath;
            this.realPath = realPath;
        }

        // Expose methods/properties of the underlying stream (delegation)
        public OutputStream getOutputStream() { return underlyingStream; }

        @Override
        public void close() throws IOException {
            if (closed) return;
            try {
                underlyingStream.close();
                // os.replace(self._tmp_filename, self._real_filename) -> Java equivalent: Files.move
                Files.move(tempPath, realPath, StandardCopyOption.REPLACE_EXISTING);
            } finally {
                closed = true;
            }
        }

        // Implementing AutoCloseable for try-with-resources compatibility
    }


    // --- ANSI and TTY Handling ---

    /**
     * Strips ANSI escape codes from a string.
     */
    public static String stripAnsi(String value) {
        return ANSI_RE.matcher(value).replaceAll("");
    }

    private static boolean isJupyterKernelOutput(InputStream stream) {
        // Highly complex check, simplified to always return false unless specific module checks are available.
        return false;
    }

    /**
     * Determines if ANSI codes should be stripped based on the stream and color flag.
     */
    public static boolean shouldStripAnsi(InputStream stream, Boolean color) {
        if (color != null) {
            return !color;
        }
        // Simplified check for TTY status
        boolean isTty = System.console() != null && System.console().isTerminal(); // Placeholder for actual TTY check
        return !isTty && !isJupyterKernelOutput(stream);
    }

    /**
     * Utility class to hold a Pair of results (used for openStream return type).
     */
    public static class Pair<A, B> {
        private final A first;
        private final B second;
        public Pair(A first, B second) { this.first = first; this.second = second; }
        public A getFirst() { return first; }
        public B getSecond() { return second; }
    }


    // --- Main Execution/Entry Point (Simulating module scope variables) ---

    private static final Supplier<Reader> defaultTextStdin = () -> null; // Placeholder for cached stream logic
    private static final Supplier<Writer> defaultTextStdout = () -> null;
    private static final Supplier<Writer> defaultTextStderr = () -> null;


    public static Map<String, Supplier<InputStream>> getBinaryStreams() {
        Map<String, Supplier<InputStream>> map = new HashMap<>();
        map.put("stdin", StreamUtils::getBinaryStdin);
        map.put("stdout", StreamUtils::getBinaryStdout);
        map.put("stderr", StreamUtils::getBinaryStderr);
        return Collections.unmodifiableMap(map);
    }

    public static Map<String, BiFunction<String, String, Writer>> getTextStreams() {
        Map<String, BiFunction<String, String, Writer>> map = new HashMap<>();
        // Using lambda to capture the method reference and parameters
        map.put("stdin", (enc, err) -> { try { return getTextStdin(enc, err); } catch (IOException e) { throw new RuntimeException(e); } });
        map.put("stdout", (enc, err) -> { try { return getTextStdout(enc, err); } catch (IOException e) { throw new RuntimeException(e); } });
        map.put("stderr", (enc, err) -> { try { return getTextStderr(enc, err); } catch (IOException e) { throw new RuntimeException(e); } });
        return Collections.unmodifiableMap(map);
    }

    // Note: Due to the massive amount of boilerplate and platform-specific details required for a perfect translation,
    // this Java code provides the structural framework and core logic flow using standard Java APIs (java.io, java.nio.file)
    // while acknowledging that some Pythonic behaviors (like automatic stream wrapping or dynamic attribute access)
    // require significant simplification or external libraries in Java.
}