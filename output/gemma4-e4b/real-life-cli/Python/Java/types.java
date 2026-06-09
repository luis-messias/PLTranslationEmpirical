import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// --- Mock/Placeholder Classes for Dependencies ---
// In a real project, these would be fully implemented.

/** Represents the context of parameter conversion. */
class Context {
    private Function<Object, Object> tokenNormalizeFunc;
    public void callOnClose(Runnable action) {} // Placeholder
    public void setTokenNormalizeFunc(Function<Object, Object> func) { this.tokenNormalizeFunc = func; }
}

/** Represents a parameter definition. */
class Parameter {
    private String paramTypeName;
    public boolean isRequired() { return true; } // Mock implementation
    public String getParamTypeName() { return "argument"; } // Mock implementation
}

/** Custom exception for bad parameters. */
class BadParameter extends RuntimeException {
    public BadParameter(String message, Context ctx, Parameter param) { super(message); }
}

/** Placeholder for utility functions and constants. */
class Utils {
    public static String formatFilename(Object value) { return value != null ? value.toString() : "unknown"; }
    public static boolean isFileLike(Object value) { return value instanceof java.io.Closeable; } // Simplified check
}

/** Placeholder for gettext functionality (i18n). */
class I18n {
    public static String _(String format, Object... args) { return String.format(format, args); }
    public static String ngettext(String formatOne, String formatTwo, int count, Object... args) { return "NGETTEXT_RESULT"; }
}

/** Placeholder for file handling utilities. */
class FileUtils {
    public static Path resolvePath(Object value) throws IOException {
        return Path.of(value.toString());
    }
}

/** Represents a completion item for shell autocompletion. */
record CompletionItem(String suggestion, String type) {}

/** Placeholder for lazy file handling. */
class LazyFile implements java.io.Closeable {
    public void closeIntelligently() throws IOException {}
}


// --- Core ParamType Abstraction ---

abstract class ParamType {
    private static final boolean IS_COMPOSITE = false; // Python ClassVar replacement
    protected int arity = 1;

    protected String name;
    protected String envvarListSplitter = null;

    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = new HashMap<>();
        String paramType = this.getClass().getSimpleName().replace("ParamType", "");
        if (this.name != null) {
            infoDict.put("param_type", paramType);
            infoDict.put("name", name);
        } else {
             infoDict.put("param_type", paramType);
             infoDict.put("name", "default");
        }
        return infoDict;
    }

    /**
     * Converts the raw value into the specific type expected by this parameter.
     */
    public abstract Object convert(Object value, Parameter param, Context ctx);

    /** Splits an environment variable string into a sequence of strings. */
    public List<String> splitEnvvarValue(String rv) {
        if (envvarListSplitter == null || envvarListSplitter.isEmpty()) {
            return Collections.singletonList(rv != null ? rv : "");
        }
        return Arrays.asList(rv.split(Pattern.quote(envvarListSplitter)));
    }

    /** Throws a BadParameter exception if conversion fails. */
    protected void fail(String message, Parameter param, Context ctx) {
        throw new BadParameter(message, ctx, param);
    }

    public abstract List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete);
}


// --- Concrete ParamType Implementations ---

class CompositeParamType extends ParamType {
    private static final boolean IS_COMPOSITE = true;

    @Override
    public int getArity() {
        throw new UnsupportedOperationException("Must implement arity getter.");
    }
}

class FuncParamType extends ParamType {
    private final Function<Object, Object> func;

    public FuncParamType(Function<Object, Object> func) {
        this.func = func;
        // Determine name based on function or class structure (approximation)
        this.name = "function_type"; 
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        infoDict.put("func", this.func);
        return infoDict;
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        try {
            return func.apply(value);
        } catch (Exception e) {
            try {
                String strValue = String.valueOf(value);
                // Attempt to decode if necessary (Python's UnicodeError handling approximation)
                if (strValue.contains("�")) { 
                    // Fallback decoding logic placeholder
                }
                throw new BadParameter("Conversion failed for function type.", ctx, param);
            } catch (BadParameter e) {
                throw e;
            } catch (Exception ex) {
                 throw new BadParameter("Failed to convert value using function: " + ex.getMessage(), ctx, param);
            }
        }
    }
}

class UnprocessedParamType extends ParamType {
    private static final String NAME = "text";

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        return value;
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}

class StringParamType extends ParamType {
    private static final String NAME = "text";

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        if (value instanceof byte[]) {
            // Complex encoding logic approximation: assuming UTF-8 for simplicity
            try {
                return new String((byte[]) value, Charset.forName("UTF-8"));
            } catch (Exception e) {
                return String.valueOf(value); // Fallback
            }
        }
        return String.valueOf(value);
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}

class Choice extends ParamType {
    private final List<String> choices;
    private final boolean caseSensitive;

    public Choice(List<String> choices, boolean caseSensitive) {
        this.choices = choices;
        this.caseSensitive = caseSensitive;
        this.name = "choice";
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        infoDict.put("choices", this.choices);
        infoDict.put("case_sensitive", this.caseSensitive);
        return infoDict;
    }

    public String getMetavar(Parameter param) {
        String choicesStr = String.join("|", choices);
        if (param.isRequired() && "argument".equals(param.getParamTypeName())) {
            return "{" + choicesStr + "}";
        }
        return "[" + choicesStr + "]";
    }

    public String getMissingMessage(Parameter param) {
        return I18n._("Choose from:\n\t{choices}", String.join(",\n\t", choices));
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        String normedValue = (value == null) ? "" : String.valueOf(value);
        Map<String, String> normedChoices = new HashMap<>();
        for (String choice : choices) {
            normedChoices.put(choice, choice);
        }

        if (ctx != null && ctx.tokenNormalizeFunc != null) {
            // Normalize value and choices map keys
            normedValue = String.valueOf(ctx.tokenNormalizeFunc.apply(value));
            Map<String, String> tempChoices = new HashMap<>();
            for (String choice : choices) {
                tempChoices.put(String.valueOf(ctx.tokenNormalizeFunc.apply(choice)), choice);
            }
            normedChoices.clear();
            normedChoices.putAll(tempChoices);
        }

        if (!caseSensitive) {
            normedValue = normedValue.toLowerCase();
            Map<String, String> tempChoices = new HashMap<>();
            for (String choice : choices) {
                tempChoices.put(choice.toLowerCase(), choice);
            }
            normedChoices.clear();
            normedChoices.putAll(tempChoices);
        }

        if (normedChoices.containsKey(normedValue)) {
            return normedChoices.get(normedValue);
        }

        String choicesStr = String.join(", ", choices.stream().map(Object::toString).collect(Collectors.toList()));
        String message = I18n.ngettext("{\"value!r} is not {choice}.", "{\"value!r} is not one of {choices}.", 
                                          Math.max(1, choices.size()), 
                                          String.valueOf(value), choicesStr, choicesStr);

        fail(message, param, ctx);
        return null; // Unreachable due to fail()
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        List<String> matched = new ArrayList<>();
        for (String choice : choices) {
            boolean match = caseSensitive ? choice.startsWith(incomplete) : choice.toLowerCase().startsWith(incomplete.toLowerCase());
            if (match) {
                matched.add(new CompletionItem(choice, "choice"));
            }
        }
        return matched;
    }
}

class DateTime extends ParamType {
    private final List<String> formats;

    public DateTime(List<String> formats) {
        this.formats = (formats != null && !formats.isEmpty()) ? formats : Arrays.asList(
            "yyyy-MM-dd",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss"
        );
        this.name = "datetime";
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        infoDict.put("formats", this.formats);
        return infoDict;
    }

    public String getMetavar(Parameter param) {
        return "[" + String.join("|", formats) + "]";
    }

    private LocalDateTime tryToConvertDate(Object value, String format) {
        try {
            String strValue = String.valueOf(value);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(strValue, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        if (value instanceof LocalDateTime) {
            return value;
        }

        for (String format : formats) {
            LocalDateTime converted = tryToConvertDate(value, format);
            if (converted != null) {
                return converted;
            }
        }

        String formatsStr = String.join(", ", formats.stream().map(Object::toString).collect(Collectors.toList()));
        String message = I18n.ngettext("{\"value!r} does not match the format {format}.", "{\"value!r} does not match the formats {formats}.", 
                                          Math.max(1, formats.size()), 
                                          String.valueOf(value), formatsStr, formatsStr);

        fail(message, param, ctx);
        return null; // Unreachable
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


// --- Number Param Types Base Classes ---

abstract class NumberParamTypeBase extends ParamType {
    protected abstract Class<? extends Number> getNumberClass();

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        try {
            return getNumberClass().getDeclaredConstructor().newInstance().getClass().cast(Number.valueOf(String.valueOf(value)));
        } catch (Exception e) {
            String message = String.format("{\"value!r} is not a valid %s.", name);
            fail(message, param, ctx);
            return null; // Unreachable
        }
    }
}

class NumberRangeBase extends NumberParamTypeBase {
    protected Double min = null;
    protected Double max = null;
    protected boolean minOpen = false;
    protected boolean maxOpen = false;
    protected boolean clamp = false;

    public NumberRangeBase(Double min, Double max, boolean minOpen, boolean maxOpen, boolean clamp) {
        this.min = min;
        this.max = max;
        this.minOpen = minOpen;
        this.maxOpen = maxOpen;
        this.clamp = clamp;
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        infoDict.put("min", min);
        infoDict.put("max", max);
        infoDict.put("min_open", minOpen);
        infoDict.put("max_open", maxOpen);
        infoDict.put("clamp", clamp);
        return infoDict;
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        Number numberValue = (Number) super.convert(value, param, ctx);
        double rv = numberValue.doubleValue();

        boolean ltMin = min != null && (minOpen ? rv < min : rv <= min);
        boolean gtMax = max != null && (maxOpen ? rv > max : rv >= max);

        if (clamp) {
            if (ltMin) {
                return clamp(this.min, 1, this.minOpen);
            }
            if (gtMax) {
                return clamp(this.max, -1, this.maxOpen);
            }
        }

        if (ltMin || gtMax) {
            String message = String.format("{\"value} is not in the range {range}.", 
                                          String.valueOf(rv), describeRange());
            fail(message, param, ctx);
            return null; // Unreachable
        }

        return numberValue;
    }

    protected double clamp(double bound, int dir, boolean open) {
        if (!open) return bound;
        return (dir == 1 ? Math.max(bound, bound + 1) : Math.min(bound, bound - 1)); // Simplified clamping logic
    }

    public String describeRange() {
        StringBuilder sb = new StringBuilder();
        boolean minSet = min != null;
        boolean maxSet = max != null;

        if (!minSet && !maxSet) return "x";

        if (minSet && !maxSet) {
            String op = minOpen ? ">" : ">=";
            return String.format("x%s%.1f", op, min);
        }

        if (!minSet && maxSet) {
            String op = maxOpen ? "<" : "<=";
            return String.format("%.1f%s x", max, op);
        }

        // Both min and max set
        String lop = minOpen ? "<" : "<=";
        String rop = maxOpen ? ">" : ">=";
        return String.format("%.1f%s x%s%.1f", min, lop, rop, max);
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class IntParamType extends NumberParamTypeBase {
    private static final String NAME = "integer";

    public IntParamType() {
        super.name = NAME;
    }

    @Override
    protected Class<? extends Number> getNumberClass() { return Integer.class; }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        return super.convert(value, param, ctx);
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class IntRange extends NumberRangeBase {
    private static final String NAME = "integer range";

    public IntRange(Double min, Double max, boolean minOpen, boolean maxOpen, boolean clamp) {
        super(min, max, minOpen, maxOpen, clamp);
        this.name = NAME;
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        return super.convert(value, param, ctx);
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class FloatParamType extends NumberParamTypeBase {
    private static final String NAME = "float";

    public FloatParamType() {
        super.name = NAME;
    }

    @Override
    protected Class<? extends Number> getNumberClass() { return Double.class; }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        return super.convert(value, param, ctx);
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class FloatRange extends NumberRangeBase {
    private static final String NAME = "float range";

    public FloatRange(Double min, Double max, boolean minOpen, boolean maxOpen, boolean clamp) {
        super(min, max, minOpen, maxOpen, clamp);
        this.name = NAME;
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        return super.convert(value, param, ctx);
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class BoolParamType extends ParamType {
    private static final String NAME = "boolean";

    public BoolParamType() {
        super.name = NAME;
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        String norm = String.valueOf(value).trim().toLowerCase();

        if (norm.equals("1") || norm.equals("true") || norm.equals("t") || norm.equals("yes") || norm.equals("y") || norm.equals("on")) {
            return true;
        }

        if (norm.equals("0") || norm.equals("false") || norm.equals("f") || norm.equals("no") || norm.equals("n") || norm.equals("off")) {
            return false;
        }

        String message = String.format("{\"value!r} is not a valid boolean.", value);
        fail(message, param, ctx);
        return null; // Unreachable
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class UUIDParameterType extends ParamType {
    private static final String NAME = "uuid";

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        java.util.UUID uuid;
        try {
            if (value instanceof java.util.UUID) {
                return (java.util.UUID) value;
            }
            String strValue = String.valueOf(value).trim();
            uuid = java.util.UUID.fromString(strValue);
            return uuid;
        } catch (IllegalArgumentException e) {
            String message = String.format("{\"value!r} is not a valid UUID.", value);
            fail(message, param, ctx);
            return null; // Unreachable
        }
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


class File extends ParamType {
    private final String mode;
    private final String encoding;
    private final String errors;
    private final Boolean lazy;
    private final boolean atomic;

    public File(String mode, String encoding, String errors, Boolean lazy, boolean atomic) {
        this.mode = mode;
        this.encoding = encoding;
        this.errors = errors;
        this.lazy = lazy;
        this.atomic = atomic;
        this.name = "filename";
        this.envvarListSplitter = java.io.File.separator; // Approximation of os.path.pathsep
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        infoDict.put("mode", mode);
        infoDict.put("encoding", encoding);
        return infoDict;
    }

    private boolean resolveLazyFlag(Object value) {
        if (lazy != null) return lazy;
        String pathStr = String.valueOf(value);
        if ("-".equals(pathStr)) return false;
        return mode.contains("w");
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        // Simplified type handling: assume Path or String input
        String pathValue = String.valueOf(value); 
        Path resolvedPath = Paths.get(pathValue);

        try {
            boolean lazy = resolveLazyFlag(value);

            if (lazy) {
                LazyFile lf = new LazyFile(); // Placeholder instantiation
                // In a real scenario, we'd pass path details to LazyFile constructor
                return lf; 
            } else {
                // Simulate opening stream
                java.io.InputStream is = Files.newInputStream(resolvedPath);
                if (ctx != null) {
                    // Placeholder for resource management hook
                }
                return is;
            }
        } catch (IOException e) {
            String message = String.format("'%s': %s", Utils.formatFilename(value), e.getMessage());
            fail(message, param, ctx);
            return null; // Unreachable
        }
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.singletonList(new CompletionItem(incomplete, "file"));
    }
}


class Path extends ParamType {
    private final boolean exists;
    private final boolean fileOkay;
    private final boolean dirOkay;
    private final boolean readable;
    private final boolean writable;
    private final boolean executable;
    private final boolean resolvePath;
    private final boolean allowDash;
    private final Class<?> type;

    public Path(boolean exists, boolean fileOkay, boolean dirOkay, boolean writable, boolean readable, 
                boolean resolvePath, boolean allowDash, Class<?> type) {
        this.exists = exists;
        this.fileOkay = fileOkay;
        this.dirOkay = dirOkay;
        this.readable = readable;
        this.writable = writable;
        this.executable = executable;
        this.resolvePath = resolvePath;
        this.allowDash = allowDash;
        this.type = type;

        if (fileOkay && !dirOkay) {
            this.name = "file";
        } else if (dirOkay && !fileOkay) {
            this.name = "directory";
        } else {
            this.name = "path";
        }
        this.envvarListSplitter = java.io.File.separator;
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        infoDict.put("exists", exists);
        infoDict.put("file_okay", fileOkay);
        infoDict.put("dir_okay", dirOkay);
        infoDict.put("writable", writable);
        infoDict.put("readable", readable);
        infoDict.put("allow_dash", allowDash);
        return infoDict;
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        String pathValue = String.valueOf(value);
        Path resolvedPath = Paths.get(pathValue);

        boolean isDash = fileOkay && allowDash && (pathValue.equals("-"));

        if (!isDash) {
            try {
                Path finalPath = resolvePath ? Files.readSymbolicLink(resolvedPath).toAbsolutePath() : resolvedPath;
                // Simulate stat check and validation logic here...
                
                // Check existence if required
                if (this.exists && !Files.exists(finalPath)) {
                    String message = String.format("%s %s does not exist.", 
                                                  name.substring(0, 1).toUpperCase() + name.substring(1), Utils.formatFilename(value));
                    fail(message, param, ctx);
                    return null; // Unreachable
                }

                // Check file/dir type constraints (simplified)
                if (!fileOkay && Files.isRegularFile(finalPath)) {
                     String message = String.format("%s %s is a file.", name.substring(0, 1).toUpperCase() + name.substring(1), Utils.formatFilename(value));
                    fail(message, param, ctx);
                    return null; // Unreachable
                }

            } catch (IOException e) {
                // Handle path resolution errors
                String message = String.format("Path error: %s", e.getMessage());
                fail(message, param, ctx);
                return null; // Unreachable
            }
        }
        return pathValue;
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        String type = (dirOkay && !fileOkay) ? "dir" : "file";
        return Collections.singletonList(new CompletionItem(incomplete, type));
    }
}

class Tuple extends CompositeParamType {
    private final List<ParamType> types;

    public Tuple(List<? extends ParamType> types) {
        this.types = new ArrayList<>(types);
    }

    @Override
    public Map<String, Object> toInfoDict() {
        Map<String, Object> infoDict = super.toInfoDict();
        List<Map<String, Object>> typeInfos = this.types.stream()
                .map(ParamType::toInfoDict)
                .collect(Collectors.toList());
        infoDict.put("types", typeInfos);
        return infoDict;
    }

    public String getName() {
        return "<" + types.stream().map(p -> p.name).collect(Collectors.joining(" ")) + ">";
    }

    public int getArity() {
        return types.size();
    }

    @Override
    public Object convert(Object value, Parameter param, Context ctx) {
        if (!(value instanceof Collection<?>)) {
            throw new BadParameter("Tuple expected a collection.", ctx, param);
        }
        Collection<?> values = (Collection<?>) value;
        int lenType = types.size();
        int lenValue = values.size();

        if (lenValue != lenType) {
            String message = I18n.ngettext("{\"len_type} values are required, but {len_value} was given.", 
                                          "{\"len_type} values are required, but {len_value} were given.", 
                                          Math.max(1, lenValue), 
                                          lenType, lenValue);
            fail(message, param, ctx);
            return null; // Unreachable
        }

        List<Object> results = new ArrayList<>();
        Iterator<?> it = values.iterator();
        for (ParamType type : types) {
            if (!it.hasNext()) break;
            results.add(type.convert(it.next(), param, ctx));
        }
        return tuple(results); // Helper to convert List<Object> to Tuple/Array equivalent
    }

    // Helper method to simulate Python's tuple conversion for return type consistency
    private Object tuple(List<Object> list) {
        return java.util.Arrays.asList(list.toArray()); 
    }

    @Override
    public List<CompletionItem> shellComplete(Context ctx, Parameter param, String incomplete) {
        return Collections.emptyList();
    }
}


// --- Utility Functions and Global Instances ---

class ParamTypeFactory {
    /** Simulates the type guessing logic from Python. */
    public static ParamType convertType(Class<?> ty, Class<?> defaultVal) {
        if (ty == null && defaultVal != null) {
            if (defaultVal.isArray() || java.util.Collection.class.isAssignableFrom(defaultVal)) {
                Object item = defaultVal.length > 0 ? defaultVal[0] : null;
                if (item != null) {
                    Class<?> inferredType = item.getClass();
                    // Handle tuple/list inference
                    if (java.util.Collection.class.isAssignableFrom(inferredType)) {
                        return new Tuple(Arrays.asList(new StringParamType(), new StringParamType())); // Placeholder for dynamic type list
                    } else {
                        // Simple type inference
                        switch (inferredType) {
                            case Integer.class: return INT;
                            case Double.class: return FLOAT;
                            case Boolean.class: return BOOL;
                            default: return STRING;
                        }
                    }
                }
            } else {
                // Simple type inference from default value
                if (defaultVal instanceof String) return STRING;
                if (defaultVal instanceof Integer) return INT;
                if (defaultVal instanceof Double) return FLOAT;
                if (defaultVal instanceof Boolean) return BOOL;
            }
        }

        if (ty == String.class || ty == null) {
            return STRING;
        }
        if (ty == Integer.class) {
            return INT;
        }
        if (ty == Double.class) {
            return FLOAT;
        }
        if (ty == Boolean.class) {
            return BOOL;
        }

        // If it's already a ParamType instance, return it
        if (ParamType.class.isAssignableFrom(ty)) {
             try {
                return (ParamType) ty.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                 System.err.println("Error instantiating type: " + e.getMessage());
            }
        }

        // Fallback to Function Param Type
        return new FuncParamType(value -> null); // Placeholder function
    }
}


public class ParameterTypeRegistry {

    public static final UnprocessedParamType UNPROCESSED = new UnprocessedParamType();
    public static final StringParamType STRING = new StringParamType();
    public static final IntParamType INT = new IntParamType();
    public static final FloatParamType FLOAT = new FloatParamType();
    public static final BoolParamType BOOL = new BoolParamType();
    public static final UUIDParameterType UUID = new UUIDParameterType();

    // Example initialization for complex types (requires actual parameters/values)
    public static final Choice CHOICE_EXAMPLE = new Choice(Arrays.asList("A", "B"), true);


    public static void main(String[] args) {
        // Main execution logic placeholder
    }
}