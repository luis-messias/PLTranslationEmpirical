import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class StreamUtils {

    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("win");
    
    // ANSI escape sequence regex equivalent
    private static final Pattern ANSI_PATTERN = Pattern.compile("\\033\\[[;?0-9]*[a-zA-Z]");
    
    // WeakKeyDictionary equivalent using ConcurrentHashMap with stream as key
    private static final Map<Object, Object> ansiStreamWrappers = new ConcurrentHashMap<>();

    /**
     * Checks if a given encoding is ASCII.
     */
    public static boolean isAsciiEncoding(String encoding) {
        try {
            return Charset.isSupported(encoding) && 
                   java.nio.charset.Charset.forName(encoding).name().equals("ASCII");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the best available encoding for a stream.
     */
    public static String getBestEncoding(ReadableByteChannel channel, Charset defaultCharset) {
        if (channel == null || !hasAttribute(channel, "encoding")) {
            return defaultCharset.name();
        }
        
        // Check if it's ASCII - upgrade to UTF-8 for better compatibility
        try {
            String encoding = getEncodingFromChannel(channel);
            if (isAsciiEncoding(encoding)) {
                return "UTF-8";
            }
            return encoding;
        } catch (Exception e) {
            return defaultCharset.name();
        }
    }

    private static boolean hasAttribute(Object channel, String attribute) {
        try {
            java.lang.reflect.Field field = null;
            for (Class<?> clazz = channel.getClass(); 
                 clazz != null && !clazz.isPrimitive() && !clazz.getName().equals("java.io.InputStream") && 
                 !clazz.getName().equals("java.io.OutputStream"); clazz = clazz.getSuperclass()) {
                try {
                    field = clazz.getDeclaredField(attribute);
                    break;
                } catch (NoSuchFieldException e) {
                    continue;
                }
            }
            
            if (field != null && !Modifier.isStatic(field.getModifiers())) {
                return true;
            }
        } catch (Exception ignored) {}
        
        return false;
    }

    private static String getEncodingFromChannel(Object channel) throws IOException, ReflectiveOperationException {
        try {
            java.lang.reflect.Field encodingField = null;
            
            for (Class<?> clazz = channel.getClass(); 
                 clazz != null && !clazz.isPrimitive() && !clazz.getName().equals("java.io.InputStream") && 
                 !clazz.getName().equals("java.io.OutputStream"); clazz = clazz.getSuperclass()) {
                try {
                    encodingField = clazz.getDeclaredField("encoding");
                    break;
                } catch (NoSuchFieldException e) {
                    continue;
                }
            }
            
            if (encodingField != null && !Modifier.isStatic(encodingField.getModifiers())) {
                return (String) encodingField.get(channel);
            }
        } catch (Exception ignored) {}
        
        throw new IOException("Could not determine stream encoding");
    }

    /**
     * Checks if a stream is binary.
     */
    public static boolean isBinaryReader(Object stream, boolean defaultToFalse) {
        try {
            return readZero(stream) instanceof byte[];
        } catch (Exception e) {
            return defaultToFalse;
        }
    }

    private static Object readZero(Object stream) throws IOException {
        if (!(stream instanceof InputStream)) {
            throw new ClassCastException("Expected InputStream");
        }
        
        try (InputStream is = (InputStream) stream) {
            byte[] buffer = new byte[0];
            return is.read(buffer);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Checks if a stream can write binary data.
     */
    public static boolean isBinaryWriter(Object stream, boolean defaultToFalse) {
        try {
            ((OutputStream) stream).write(new byte[0]);
            return true;
        } catch (Exception e1) {
            try {
                ((OutputStream) stream).write(""); // This will fail for text streams
                return false;
            } catch (Exception ignored) {}
            
            return defaultToFalse;
        }
    }

    /**
     * Finds a binary reader in the stream hierarchy.
     */
    public static InputStream findBinaryReader(Object stream, boolean checkBuffer) {
        if (isBinaryReader(stream, false)) {
            return (InputStream) stream;
        }
        
        Object buffer = getAttribute(stream, "buffer");
        if (buffer != null && isBinaryReader(buffer, true)) {
            return (InputStream) buffer;
        }
        
        return null;
    }

    private static Object getAttribute(Object obj, String attribute) throws ReflectiveOperationException {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(attribute);
            if (!Modifier.isStatic(field.getModifiers())) {
                return field.get(obj);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {}
        
        throw new IOException("Could not get attribute: " + attribute);
    }

    /**
     * Finds a binary writer in the stream hierarchy.
     */
    public static OutputStream findBinaryWriter(Object stream, boolean checkBuffer) {
        if (isBinaryWriter(stream, false)) {
            return (OutputStream) stream;
        }
        
        Object buffer = getAttribute(stream, "buffer");
        if (buffer != null && isBinaryWriter(buffer, true)) {
            return (OutputStream) buffer;
        }
        
        return null;
    }

    /**
     * Checks if a text stream has ASCII encoding.
     */
    public static boolean isMisconfiguredTextStream(Readable reader) throws IOException {
        String encoding = getEncodingFromReader(reader);
        return isAsciiEncoding(encoding != null ? encoding : "ASCII");
    }

    private static String getEncodingFromReader(Object obj) throws ReflectiveOperationException, IOException {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField("encoding");
            if (!Modifier.isStatic(field.getModifiers())) {
                return (String) field.get(obj);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {}
        
        throw new IOException("Could not get encoding from reader");
    }

    /**
     * Checks compatibility of text stream attributes.
     */
    public static boolean isCompatibleTextStream(Readable reader, 
                                                 String expectedEncoding,
                                                 String expectedErrors) throws ReflectiveOperationException {
        try {
            java.lang.reflect.Field encodingField = null;
            
            for (Class<?> clazz = reader.getClass(); 
                 clazz != null && !clazz.isPrimitive() && !clazz.getName().equals("java.io.Reader"); 
                 clazz = clazz.getSuperclass()) {
                try {
                    encodingField = clazz.getDeclaredField("encoding");
                    break;
                } catch (NoSuchFieldException e) {}
            }
            
            if (expectedEncoding != null && expectedErrors == null) {
                return true; // Simplified check for Java implementation
            }
        } catch (ReflectiveOperationException ignored) {}
        
        return false;
    }

    /**
     * Forces correct text stream configuration.
     */
    public static Reader forceCorrectTextReader(Object textStream, 
                                                String encoding,
                                                String errors,
                                                boolean forceReadable) throws IOException {
        if (isBinaryReader(textStream, false)) {
            return new InputStreamReader((InputStream) textStream, getCharset(encoding));
        } else {
            // Already a Reader - check compatibility and wrap as needed
            try {
                java.lang.reflect.Field encodingField = null;
                
                for (Class<?> clazz = textStream.getClass(); 
                     clazz != null && !clazz.isPrimitive() && !clazz.getName().equals("java.io.Reader"); 
                     clazz = clazz.getSuperclass()) {
                    try {
                        encodingField = clazz.getDeclaredField("encoding");
                        break;
                    } catch (NoSuchFieldException e) {}
                }
                
                if (expectedEncoding != null || expectedErrors == null) {
                    return new InputStreamReader((InputStream) textStream, getCharset(encoding));
                }
            } catch (ReflectiveOperationException ignored) {}
            
            // Return as-is or wrap with appropriate encoding
            try {
                java.lang.reflect.Field encodingField = 
                    ((java.io.Reader) textStream).getClass().getDeclaredField("encoding");
                
                if (!Modifier.isStatic(encodingField.getModifiers())) {
                    String currentEncoding = (String) encodingField.get(textStream);
                    
                    // If ASCII, upgrade to UTF-8 for better compatibility
                    if (isAsciiEncoding(currentEncoding)) {
                        return new InputStreamReader((InputStream) textStream, getCharset("UTF-8"));
                    }
                }
            } catch (ReflectiveOperationException ignored) {}
            
            return (Reader) textStream;
        }
    }

    private static Charset getCharset(String encodingName) throws IOException {
        try {
            if (encodingName == null || "null".equals(encodingName)) {
                // Use platform default or UTF-8 as fallback
                String preferred = System.getProperty("file.encoding");
                return java.nio.charset.Charset.forName(preferred != null ? preferred : "UTF-8");
            } else {
                return Charset.forName(encodingName);
            }
        } catch (Exception e) {
            throw new IOException("Invalid encoding: " + encodingName, e);
        }
    }

    /**
     * Forces correct text writer configuration.
     */
    public static Writer forceCorrectTextWriter(Object textStream, 
                                                String encoding,
                                                String errors,
                                                boolean forceWritable) throws IOException {
        if (isBinaryWriter(textStream, false)) {
            return new OutputStreamWriter((OutputStream) textStream, getCharset(encoding));
        } else {
            // Already a Writer - check compatibility and wrap as needed
            try {
                java.lang.reflect.Field encodingField = null;
                
                for (Class<?> clazz = textStream.getClass(); 
                     clazz != null && !clazz.isPrimitive() && !clazz.getName().equals("java.io.Writer"); 
                     clazz = clazz.getSuperclass()) {
                    try {
                        encodingField = clazz.getDeclaredField("encoding");
                        break;
                    } catch (NoSuchFieldException e) {}
                }
                
                if (expectedEncoding != null || expectedErrors == null) {
                    return new OutputStreamWriter((OutputStream) textStream, getCharset(encoding));
                }
            } catch (ReflectiveOperationException ignored) {}
            
            // Return as-is or wrap with appropriate encoding
            try {
                java.lang.reflect.Field encodingField = 
                    ((java.io.Writer) textStream).getClass().getDeclaredField("encoding");
                
                if (!Modifier.isStatic(encodingField.getModifiers())) {
                    String currentEncoding = (String) encodingField.get(textStream);
                    
                    // If ASCII, upgrade to UTF-8 for better compatibility
                    if (isAsciiEncoding(currentEncoding)) {
                        return new OutputStreamWriter((OutputStream) textStream, getCharset("UTF-8"));
                    }
                }
            } catch (ReflectiveOperationException ignored) {}
            
            return (Writer) textStream;
        }
    }

    /**
     * Gets binary stdin stream.
     */
    public static InputStream getBinaryStdin() throws IOException {
        Object reader = findBinaryReader(System.in, false);
        if (reader == null) {
            throw new RuntimeException("Was not able to determine binary stream for System.in.");
        }
        return (InputStream) reader;
    }

    /**
     * Gets binary stdout stream.
     */
    public static OutputStream getBinaryStdout() throws IOException {
        Object writer = findBinaryWriter(System.out, false);
        if (writer == null) {
            throw new RuntimeException("Was not able to determine binary stream for System.out.");
        }
        return (OutputStream) writer;
    }

    /**
     * Gets binary stderr stream.
     */
    public static OutputStream getBinaryStderr() throws IOException {
        Object writer = findBinaryWriter(System.err, false);
        if (writer == null) {
            throw new RuntimeException("Was not able to determine binary stream for System.err.");
        }
        return (OutputStream) writer;
    }

    /**
     * Gets text stdin stream.
     */
    public static Reader getTextStdin(String encoding, String errors) throws IOException {
        Object result = getWindowsConsoleStream(System.in, encoding, errors);
        
        if (result != null) {
            return (Reader) result;
        }
        
        // Fall back to forcing correct reader with force_readable=true equivalent
        return forceCorrectTextReader(System.in, encoding, errors, true);
    }

    /**
     * Gets text stdout stream.
     */
    public static Writer getTextStdout(String encoding, String errors) throws IOException {
        Object result = getWindowsConsoleStream(System.out, encoding, errors);
        
        if (result != null) {
            return (Writer) result;
        }
        
        // Fall back to forcing correct writer with force_writable=true equivalent
        return forceCorrectTextWriter(System.out, encoding, errors, true);
    }

    /**
     * Gets text stderr stream.
     */
    public static Writer getTextStderr(String encoding, String errors) throws IOException {
        Object result = getWindowsConsoleStream(System.err, encoding, errors);
        
        if (result != null) {
            return (Writer) result;
        }
        
        // Fall back to forcing correct writer with force_writable=true equivalent
        return forceCorrectTextWriter(System.err, encoding, errors, true);
    }

    /**
     * Gets Windows console stream for text I/O.
     */
    private static Object getWindowsConsoleStream(Object f, 
                                                   String encoding,
                                                   String errors) {
        if (IS_WINDOWS && System.getProperty("os.name").toLowerCase().contains("windows")) {
            // On actual Windows with console support
            try {
                java.lang.reflect.Method method = Class.forName("_winconsole")
                    .getMethod("_get_windows_console_stream", Object.class, 
                                String.class, String.class);
                
                return (Object) method.invoke(null, f, encoding, errors);
            } catch (Exception ignored) {}
        }
        
        // Return null to indicate no special Windows console handling needed
        return null;
    }

    /**
     * Wraps IO for opening files.
     */
    public static Object wrapIoOpen(String file, String mode, 
                                     Charset encoding, String errors) throws IOException {
        if (mode.contains("b")) {
            // Binary mode - use raw open
            return new FileInputStream(file);
        } else {
            // Text mode with encoding
            Path path = Paths.get(file);
            
            try {
                java.nio.file.OpenOption[] options;
                
                if ("r".equals(mode)) {
                    options = new OpenOption[]{java.nio.file.StandardOpenOption.READ};
                } else if (mode.contains("w")) {
                    options = new OpenOption[]{java.nio.file.StandardOpenOption.WRITE, 
                                               java.nio.file.StandardOpenOption.CREATE_NEW};
                } else if ("a".equals(mode)) {
                    options = new OpenOption[]{java.nio.file.StandardOpenOption.APPEND, 
                                               java.nio.file.StandardOpenOption.CREATE};
                } else {
                    throw new IOException("Unsupported mode: " + mode);
                }
                
                return Files.newBufferedReader(path, encoding), true;
            } catch (Exception e) {
                // Fall back to standard approach
                if ("r".equals(mode)) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        return new InputStreamReader(fis, encoding);
                    }
                } else if (mode.contains("w")) {
                    File fileObj = Paths.get(file).toFile();
                    
                    // Atomic write handling would go here for "a" and "x" modes
                    throw new IOException("Atomic writes not supported in this implementation");
                }
                
                return null;
            }
        }
    }

    /**
     * Opens a stream with atomic file writing support.
     */
    public static Object openStream(String filename, String mode, 
                                    Charset encoding, boolean atomic) throws IOException {
        Path path = Paths.get(filename);
        
        // Handle stdin/stdout special cases (represented as "-" in Python)
        if (".".equals(path.toString())) {  // Simplified check for standard streams
            return null;
        }

        if (!atomic) {
            return wrapIoOpen(filename, mode, encoding, "strict");
        } else {
            // Atomic write implementation using temp file and rename
            
            java.nio.file.Path realPath = path.toAbsolutePath();
            
            // Generate unique temporary filename
            String tmpFilename = Paths.get(realPath.getParent().toString(), 
                                          "__atomic-write" + System.nanoTime() + ".tmp").toAbsolutePath().toString();
            
            int flags = 0;
            
            if (mode.contains("b")) {
                // Binary mode - use Files.newOutputStream with appropriate options
                java.nio.file.OpenOption[] options = new OpenOption[]{java.nio.file.StandardOpenOption.WRITE, 
                                                                       java.nio.file.StandardOpenOption.CREATE_NEW};
                
                return Files.newBufferedWriter(tmpFilename.toPath(), encoding, options);
            } else {
                // Text mode - use buffered reader/writer with temp file approach
                
                if (mode.contains("a")) {
                    throw new IOException(
                        "Appending to an existing file is not supported in this implementation");
                }
                
                if ("x".equals(mode)) {
                    throw new IllegalArgumentException("Use overwrite parameter instead.");
                }
                
                // For write mode, use CREATE_NEW flag for atomicity
                java.nio.file.OpenOption[] options = new OpenOption[]{java.nio.file.StandardOpenOption.WRITE};
                
                return Files.newBufferedWriter(tmpFilename.toPath(), encoding);
            }
        }
    }

    /**
     * Strips ANSI escape sequences from text.
     */
    public static String stripAnsi(String value) {
        if (value == null || !ANSI_PATTERN.matcher(value).find()) {
            return value;
        }
        
        // Simple replacement - in production would use a more sophisticated approach
        StringBuilder result = new StringBuilder();
        int lastEnd = 0;
        
        Matcher matcher = ANSI_PATTERN.matcher(value);
        
        while (matcher.find(lastEnd)) {
            if (lastEnd < matcher.start()) {
                result.append(value.substring(lastEnd, matcher.start()));
            }
            
            // Skip the ANSI sequence and any following text until newline or end of string
            int nextNewline = value.indexOf('\n', matcher.end());
            lastEnd = Math.max(matcher.end(), 
                               (nextNewline > 0) ? nextNewline : value.length());
        }
        
        if (lastEnd < value.length()) {
            result.append(value.substring(lastEnd));
        }
        
        return result.toString();
    }

    /**
     * Checks if a stream is Jupyter kernel output.
     */
    public static boolean isJupyterKernelOutput(Object stream) throws IOException, ReflectiveOperationException {
        // Walk through wrapper layers to find the underlying stream
        Object current = unwrapStream(stream);
        
        try {
            java.lang.reflect.Field moduleField = 
                current.getClass().getDeclaredField("module");
            
            if (!Modifier.isStatic(moduleField.getModifiers())) {
                String moduleName = (String) moduleField.get(current);
                
                return moduleName != null && moduleName.startsWith("ipykernel.");
            }
        } catch (ReflectiveOperationException ignored) {}
        
        return false;
    }

    private static Object unwrapStream(Object stream) throws ReflectiveOperationException {
        while (stream instanceof java.lang.reflect.Field || 
               stream.getClass().getName().contains("_Fixup") || 
               stream.getClass().getName().contains("NonClosing")) {
            
            try {
                // Try to get the underlying _stream field
                java.lang.reflect.Field field = stream.getClass()
                    .getDeclaredField("_stream");
                
                if (!Modifier.isStatic(field.getModifiers())) {
                    Object innerStream = field.get(stream);
                    
                    if (innerStream != null && 
                        !(innerStream instanceof InputStream) && 
                        !(innerStream instanceof OutputStream)) {
                        
                        // Check for nested wrappers - continue unwrapping
                        stream = unwrapStream(innerStream);
                        break;
                    } else {
                        return innerStream;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {}
            
            try {
                java.lang.reflect.Field field = 
                    stream.getClass().getDeclaredField("wrapped");
                
                if (!Modifier.isStatic(field.getModifiers())) {
                    Object wrapped = field.get(stream);
                    
                    if (wrapped != null && !(wrapped instanceof InputStream)) {
                        return unwrapStream(wrapped);
                    } else {
                        break;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {}
            
            // If no wrapper found, stop unwrapping
            break;
        }
        
        return stream;
    }

    /**
     * Determines if ANSI should be stripped from output.
     */
    public static boolean shouldStripAnsi(Object stream, Boolean color) {
        if (color == null || !Boolean.TRUE.equals(color)) {
            // Check if not a tty and not Jupyter kernel
            return !isTty(stream);
        } else {
            return false;  // User explicitly wants colors
        }
    }

    /**
     * Checks if stream is connected to a terminal.
     */
    public static boolean isTty(Object stream) throws IOException, ReflectiveOperationException {
        try {
            java.lang.reflect.Method method = 
                (stream != null && !Modifier.isStatic(stream.getClass().getMethod("isatty"))) ? 
                    stream : System.in;
            
            if (!method.getName().equals("isatty")) {
                return false;
            }
            
            boolean result = ((Boolean) method.invoke(method)).booleanValue();
            return result != null && result;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the length of text after stripping ANSI.
     */
    public static int termLength(String x) {
        if (x == null || !ANSI_PATTERN.matcher(x).find()) {
            return x != null ? x.length() : 0;
        } else {
            // Count non-ansi characters - simplified implementation
            StringBuilder result = new StringBuilder();
            
            Matcher matcher = ANSI_PATTERN.matcher(x);
            int lastEnd = 0;
            
            while (matcher.find(lastEnd)) {
                if (lastEnd < matcher.start()) {
                    result.append(x.substring(lastEnd, matcher.start()));
                }
                
                // Skip ANSI sequence and following text until newline or end of string
                int nextNewline = x.indexOf('\n', matcher.end());
                lastEnd = Math.max(matcher.end(), 
                                   (nextNewline > 0) ? nextNewline : x.length());
            }
            
            if (lastEnd < x.length()) {
                result.append(x.substring(lastEnd));
            }
            
            return result.toString().length();
        }
    }

    /**
     * Creates a cached stream function.
     */
    public static Function<Object, Object> makeCachedStreamFunction(
            java.util.function.Supplier<Object> srcFunc) {
        
        ConcurrentHashMap<Object, Object> cache = new ConcurrentHashMap<>();
        
        return () -> {
            Object stream = srcFunc.get();
            
            if (stream == null) {
                return null;
            }
            
            try {
                Object cached = cache.get(stream);
                
                if (cached != null) {
                    return cached;
                }
            } catch (Exception ignored) {}
            
            // In real implementation, would wrap with appropriate stream wrapper
            
            return srcFunc.get();  // Return original or wrapped as needed
        };
    }

    /**
     * Default text stdin getter.
     */
    public static Reader getDefaultTextStdin() throws IOException {
        java.util.function.Supplier<Object> supplier = () -> System.in;
        
        return (Reader) makeCachedStreamFunction(supplier).get();
    }

    /**
     * Default text stdout getter.
     */
    public static Writer getDefaultTextStdout() throws IOException {
        java.util.function.Supplier<Object> supplier = () -> System.out;
        
        return (Writer) makeCachedStreamFunction(supplier).get();
    }

    /**
     * Default text stderr getter.
     */
    public static Writer getDefaultTextStderr() throws IOException {
        java.util.function.Supplier<Object> supplier = () -> System.err;
        
        return (Writer) makeCachedStreamFunction(supplier).get();
    }

    // Binary stream getters map equivalent to Python's binary_streams dict
    private static final Map<String, Function<java.util.function.Supplier<Object>, Object>> 
            BINARY_STREAMS = new ConcurrentHashMap<>();
    
    /**
     * Text streams configuration.
     */
    public interface StreamConfig {
        String getEncoding();
        
        String getErrors();
    }

    // Main entry point for stream utilities
}