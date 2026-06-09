import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// --- Mocking External Dependencies and Exceptions for Compilation Context ---
// In a real project, these would be imported from the respective packages.

class BadArgumentUsage extends RuntimeException {
    public BadArgumentUsage(String message) { super(message); }
}
class BadOptionUsage extends RuntimeException {
    public BadOptionUsage(String message) { super(message); }
}
class NoSuchOption extends RuntimeException {
    private final String option;
    private final List<String> possibilities;
    private final Context context;

    public NoSuchOption(String option, List<String> possibilities, Context context) {
        super(String.format("Unknown option %s", option));
        this.option = option;
        this.possibilities = possibilities;
        this.context = context;
    }
    // Constructor for no possibilities/context needed if simplified
    public NoSuchOption(String option, Context context) {
        super(String.format("Unknown option %s", option));
        this.option = option;
        this.possibilities = null;
        this.context = context;
    }
}
class UsageError extends RuntimeException {
    public UsageError(String message) { super(message); }
}

// Mock Context and Core classes
class Context {
    private boolean allowInterspersedArgs = true;
    private boolean ignoreUnknownOptions = false;
    private java.util.function.Function<String, String> tokenNormalizeFunc = null;

    public boolean isAllowInterspersedArgs() { return allowInterspersedArgs; }
    public void setAllowInterspersedArgs(boolean allow) { this.allowInterspersedArgs = allow; }
    public boolean isIgnoreUnknownOptions() { return ignoreUnknownOptions; }
    public void setIgnoreUnknownOptions(boolean ignore) { this.ignoreUnknownOptions = ignore; }
    public java.util.function.Function<String, String> getTokenNormalizeFunc() { return tokenNormalizeFunc; }
}

class CoreArgument {
    private static final Object FLAG_NEEDS_VALUE = new Object();
    public static boolean needsValue() { return true; } // Mocking the flag check
    public java.util.Map<String, Object> envvar = null;
}

class CoreOption {
    // Placeholder for actual core option logic
}

/**
 * Utility class to handle argument unpacking and string splitting.
 */
final class ArgumentUtils {

    private ArgumentUtils() {} // Prevent instantiation

    public static AbstractMap.SimpleEntry<List<Object>, List<String>> unpackArgs(
            List<String> args, List<Integer> nargsSpec) {

        Deque<String> argsDeque = new ArrayDeque<>(args);
        Deque<Integer> nargsSpecDeque = new ArrayDeque<>(nargsSpec);
        List<Object> rv = new ArrayList<>();
        Integer spos = null;

        // Helper function to fetch value from deque
        java.util.function.Supplier<String> fetch = () -> {
            if (spos == null) {
                return argsDeque.pollFirst();
            } else {
                return argsDeque.pollLast();
            }
        };

        while (!nargsSpecDeque.isEmpty()) {
            Integer nargs = nargsSpecDeque.poll();

            if (nargs == null) {
                continue;
            }

            if (nargs == 1) {
                rv.add(fetch.get());
            } else if (nargs > 1) {
                List<String> x = new ArrayList<>();
                for (int i = 0; i < nargs; i++) {
                    x.add(fetch.get());
                }

                if (spos != null) {
                    Collections.reverse(x);
                }
                rv.add(tuple(x));
            } else if (nargs < 0) {
                if (spos != null) {
                    throw new IllegalArgumentException("Cannot have two nargs < 0");
                }

                spos = rv.size();
                rv.add(null); // Placeholder for variable arguments
            }
        }


        if (spos != null) {
            // Handle remaining positional arguments (the tuple of all remaining args)
            List<String> remainingArgs = new ArrayList<>();
            while (!argsDeque.isEmpty()) {
                remainingArgs.add(argsDeque.pollFirst());
            }

            rv.set(spos, tuple(remainingArgs));
            // Shift subsequent elements (if any were added after the vararg placeholder)
            List<Object> temp = new ArrayList<>();
            for (int i = spos + 1; i < rv.size(); i++) {
                temp.add((Object) rv.get(i));
            }
            rv.subList(spos + 1, rv.size()).clear();
            rv.addAll(temp);

            // The remaining arguments are now stored in the tuple at spos
        }


        @SuppressWarnings("unchecked")
        List<Object> finalRv = new ArrayList<>(rv);
        List<String> finalArgs = new ArrayList<>(); // Should be empty if logic is correct, but kept for signature match.

        return new AbstractMap.SimpleEntry<>(finalRv, finalArgs);
    }

    private static List<Object> tuple(List<String> list) {
        // Using List<Object> to represent a Python Tuple of Strings/Nones
        return list;
    }


    public static java.util.AbstractMap.SimpleEntry<String, String> splitOpt(String opt) {
        String first = "";
        if (!opt.isEmpty()) {
            first = opt.substring(0, 1);
        }

        if (Character.isLetterOrDigit(first.charAt(0))) {
            return new AbstractMap.SimpleEntry<>("", opt);
        }
        if (opt.length() >= 2 && opt.substring(1, 2).equals(first)) {
            return new AbstractMap.SimpleEntry<>(opt.substring(0, 2), opt.substring(2));
        }
        return new AbstractMap.SimpleEntry<>(first, opt.substring(1));
    }

    public static String normalizeOpt(String opt, Context ctx) {
        if (ctx == null || ctx.getTokenNormalizeFunc() == null) {
            return opt;
        }
        java.util.AbstractMap.SimpleEntry<String, String> parts = splitOpt(opt);
        String prefix = parts.getKey();
        String value = parts.getValue();

        return prefix + ctx.getTokenNormalizeFunc().apply(value);
    }

    public static List<String> splitArgString(String string) {
        // Simple implementation mimicking shlex behavior for basic splitting
        List<String> out = new ArrayList<>();
        if (string == null || string.isEmpty()) return out;

        // Basic regex split handling quotes and spaces
        Pattern pattern = Pattern.compile("([^\"'\\s]+)|(\"[^\"]*\"|'[^']*')");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String token = matcher.group();
            if (token != null) {
                // Remove quotes if present
                if ((token.startsWith("\"") && token.endsWith("\"")) || (token.startsWith("'") && token.endsWith("'"))) {
                    out.add(token.substring(1, token.length() - 1));
                } else {
                    out.add(token);
                }
            }
        }
        return out;
    }
}

/**
 * Represents a command line option (e.g., --file or -f).
 */
class Option {
    private final List<String> shortOpts = new ArrayList<>();
    private final List<String> longOpts = new ArrayList<>();
    private final Set<String> prefixes = new HashSet<>();

    public String dest;
    public String action;
    public int nargs;
    public Object const;
    public CoreOption obj;

    public Option(CoreOption obj, List<String> opts, String dest, String action, int nargs, Object constVal) {
        this.obj = obj;
        this.dest = dest;
        this.action = (action == null || action.isEmpty()) ? "store" : action;
        this.nargs = nargs;
        this.const = constVal;

        for (String opt : opts) {
            java.util.AbstractMap.SimpleEntry<String, String> parts = ArgumentUtils.splitOpt(opt);
            String prefix = parts.getKey();
            String value = parts.getValue();

            if (!prefix.isEmpty()) {
                this.prefixes.add(prefix.charAt(0));
            }
            
            // Simplified logic check for short vs long options based on Python's original intent
            if (prefix.length() == 1 && value.length() == 1) {
                shortOpts.add(opt);
            } else {
                longOpts.add(opt);
                if (!prefix.isEmpty()) {
                    this.prefixes.add(prefix);
                }
            }
        }
    }

    public boolean takesValue() {
        return "store".equals(action) || "append".equals(action);
    }

    public void process(Object value, ParsingState state) {
        if ("store".equals(this.action)) {
            state.opts.put(this.dest, value);
        } else if ("store_const".equals(this.action)) {
            state.opts.put(this.dest, this.const);
        } else if ("append".equals(this.action)) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) state.opts.computeIfAbsent(this.dest, k -> new ArrayList<>());
            list.add(value);
        } else if ("append_const".equals(this.action)) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) state.opts.computeIfAbsent(this.dest, k -> new ArrayList<>());
            list.add(this.const);
        } else if ("count".equals(this.action)) {
            state.opts.put(this.dest, ((Integer) state.opts.getOrDefault(this.dest, 0)) + 1);
        } else {
            throw new IllegalArgumentException("unknown action '" + this.action + "'");
        }
        state.order.add(this.obj);
    }

    public List<String> getShortOpts() { return shortOpts; }
    public List<String> getLongOpts() { return longOpts; }
    public Set<String> getPrefixes() { return prefixes; }
}

/**
 * Represents a positional argument.
 */
class Argument {
    public String dest;
    public int nargs;
    public CoreArgument obj;

    public Argument(CoreArgument obj, String dest, int nargs) {
        this.obj = obj;
        this.dest = dest;
        this.nargs = nargs;
    }

    public void process(Object value, ParsingState state) {
        if (this.nargs > 1) {
            assert value != null : "Value must be present for nargs > 1";
            List<String> stringValue = (List<String>) value;
            int holes = 0;
            for (String x : stringValue) {
                if (x == null) {
                    holes++;
                }
            }

            if (holes == stringValue.size()) {
                // All None/null, treat as None
                value = null;
            } else if (holes != 0) {
                throw new BadArgumentUsage(String.format("Argument %s takes %d values.", this.dest, this.nargs));
            }
        }

        if (this.nargs == -1 && this.obj.envvar != null && value == null) {
            // Python logic: if nargs=-1 and envvar exists and no value was passed, set to None
            value = null;
        }

        state.opts.put(this.dest, value);
        state.order.add(this.obj);
    }
}

/**
 * Holds the state during parsing.
 */
class ParsingState {
    public Map<String, Object> opts = new HashMap<>();
    public List<String> largs = new ArrayList<>(); // Left arguments (before options)
    public List<String> rargs = new ArrayList<>(); // Right arguments (after options/remaining)
    public List<CoreArgument> order = new ArrayList<>();

    public ParsingState(List<String> rargs) {
        this.rargs.addAll(rargs);
    }
}


/**
 * Main parser class, equivalent to Python's OptionParser.
 */
class OptionParser {

    private Context ctx;
    private boolean allowInterspersedArgs = true;
    private boolean ignoreUnknownOptions = false;

    private final Map<String, Option> shortOpt = new HashMap<>();
    private final Map<String, Option> longOpt = new HashMap<>();
    private final Set<String> optPrefixes = new HashSet<>(Arrays.asList("-", "--"));
    private final List<Argument> args = new ArrayList<>();

    public OptionParser(Context ctx) {
        this.ctx = ctx;
        if (this.ctx != null) {
            this.allowInterspersedArgs = this.ctx.isAllowInterspersedArgs();
            this.ignoreUnknownOptions = this.ctx.isIgnoreUnknownOptions();
        }
    }

    public void addOption(CoreOption obj, List<String> opts, String dest, String action, int nargs, Object constVal) {
        List<String> normalizedOpts = opts.stream()
                .map(opt -> ArgumentUtils.normalizeOpt(opt, this.ctx))
                .collect(Collectors.toList());

        Option option = new Option(obj, normalizedOpts, dest, action, nargs, constVal);
        this.optPrefixes.addAll(option.getPrefixes());

        for (String opt : option.getShortOpts()) {
            shortOpt.put(opt, option);
        }
        for (String opt : option.getLongOpts()) {
            longOpt.put(opt, option);
        }
    }

    public void addArgument(CoreArgument obj, String dest, int nargs) {
        args.add(new Argument(obj, dest, nargs));
    }

    /**
     * Parses the list of arguments into state components.
     * @return A structure containing options map, remaining left args, and parameter order.
     */
    public Map<String, Object> parseArgs(List<String> args) {
        ParsingState state = new ParsingState(args);
        try {
            processArgsForOptions(state);
            processArgsForArgs(state);
        } catch (UsageError e) {
            if (this.ctx == null || !this.ctx.isAllowInterspersedArgs()) {
                throw e;
            }
        }
        // Return a map containing the final state components for compatibility with Python return structure
        Map<String, Object> result = new HashMap<>();
        result.put("opts", state.opts);
        result.put("largs", state.largs);
        result.put("order", state.order);
        return result;
    }

    private void processArgsForArgs(ParsingState state) {
        // Note: Python's _unpack_args returns a tuple (pargs, args). We only care about the list of arguments here.
        java.util.AbstractMap.SimpleEntry<List<Object>, List<String>> result = ArgumentUtils.unpackArgs(
                state.largs + state.rargs,
                streamNargs()
        );

        // The first element (pargs) contains the processed values for arguments
        @SuppressWarnings("unchecked")
        List<Object> pargs = (List<Object>) result.getKey();
        List<String> remainingArgs = new ArrayList<>(); // This is what Python's 'args' variable holds

        for (int idx = 0; idx < args.size(); idx++) {
            Argument arg = args.get(idx);
            // We must cast the argument value to handle both single strings and lists of strings/nulls
            Object value = pargs.get(idx);
            arg.process(value, state);
        }

        state.largs = remainingArgs;
        state.rargs.clear(); // All arguments are consumed by the positional argument processing
    }

    private List<Integer> streamNargs() {
        return args.stream().map(a -> a.nargs).collect(Collectors.toList());
    }


    private void processArgsForOptions(ParsingState state) {
        while (!state.rargs.isEmpty()) {
            String arg = state.rargs.remove(0);
            int arglen = arg.length();

            if (arg.equals("--")) {
                return; // Stop processing options/arguments
            } else if (arg.startsWith("-") && arglen > 1) {
                processOpts(arg, state);
            } else if (this.allowInterspersedArgs) {
                state.largs.add(arg);
            } else {
                // If not allowing interspersed args, put it back and stop
                state.rargs.add(0, arg);
                return;
            }
        }
    }

    private void matchLongOpt(String opt, String explicitValue, ParsingState state) {
        if (!longOpt.containsKey(opt)) {
            // Mocking difflib get_close_matches functionality
            List<String> possibilities = new ArrayList<>(); // Assume lookup failed
            throw new NoSuchOption(opt, possibilities, this.ctx);
        }

        Option option = longOpt.get(opt);
        Object value;

        if (option.takesValue()) {
            if (explicitValue != null) {
                state.rargs.add(0, explicitValue);
            }
            value = getValueFromState(opt, option, state);
        } else if (explicitValue != null) {
            throw new BadOptionUsage(String.format("Option %s does not take a value.", opt));
        } else {
            value = null;
        }

        option.process(value, state);
    }

    private void matchShortOpt(String arg, ParsingState state) {
        boolean stop = false;
        int i = 1;
        char prefixChar = arg.charAt(0);
        List<Character> unknownOptions = new ArrayList<>();

        for (int j = 1; j < arg.length(); j++) {
            String optCandidate = String.valueOf(prefixChar) + arg.substring(j, j + 1);
            String normalizedOpt = ArgumentUtils.normalizeOpt(optCandidate, this.ctx);
            Option option = shortOpt.get(normalizedOpt);
            i++;

            if (option == null) {
                if (this.ignoreUnknownOptions) {
                    unknownOptions.add(arg.charAt(j));
                    continue;
                }
                throw new NoSuchOption(normalizedOpt, this.ctx);
            }

            Object value = null;
            if (option.takesValue()) {
                // Check if the next argument is available and belongs to another option
                boolean hasNextArg = i < arg.length();
                if (hasNextArg) {
                    state.rargs.add(0, arg.substring(i));
                    stop = true;
                }

                value = getValueFromState(normalizedOpt, option, state);
            } else {
                value = null;
            }

            option.process(value, state);

            if (stop) {
                break;
            }
        }

        if (this.ignoreUnknownOptions && !unknownOptions.isEmpty()) {
            String unknownStr = "" + unknownOptions.stream().map(Object::toString).collect(Collectors.joining());
            state.largs.add(String.valueOf(prefixChar) + unknownStr);
        }
    }

    private Object getValueFromState(String optionName, Option option, ParsingState state) {
        int nargs = option.nargs;

        if (state.rargs.size() < nargs) {
            // Check if the object requires a value flag
            if (option.obj.obj instanceof CoreArgument && ((CoreArgument) option.obj).obj.envvar != null) {
                return new Object(); // Mocking _flag_needs_value
            } else {
                throw new BadOptionUsage(String.format("Option %s requires %d arguments.", optionName, nargs));
            }
        } else if (nargs == 1) {
            String nextRarg = state.rargs.get(0);

            // Check for combined short options or explicit value handling
            if (((CoreArgument) option.obj).obj.envvar != null && nextRarg != null && nextRarg.length() >= 2 && nextRarg.charAt(0) == '-' ) {
                return new Object(); // Mocking _flag_needs_value
            } else {
                // Pop the value from rargs
                Object value = state.rargs.remove(0);
                return value;
            }
        } else {
            // Multiple arguments (nargs > 1)
            List<String> values = new ArrayList<>();
            for (int i = 0; i < nargs; i++) {
                values.add((String) state.rargs.remove(0));
            }
            return values;
        }
    }

    private void processOpts(String arg, ParsingState state) {
        String explicitValue = null;
        String longOptName;

        if (arg.contains("=")) {
            String[] parts = arg.split("=", 2);
            longOptName = parts[0];
            explicitValue = parts[1];
        } else {
            longOptName = arg;
        }
        String normLongOpt = ArgumentUtils.normalizeOpt(longOptName, this.ctx);

        try {
            matchLongOpt(normLongOpt, explicitValue, state);
        } catch (NoSuchOption e) {
            // If long option fails, try short option matching if it started with -x or --x
            if (!arg.startsWith("--")) {
                matchShortOpt(arg, state);
                return;
            }

            if (!this.ignoreUnknownOptions) {
                throw e;
            }
            // If ignoring unknown options and failed long match, treat as left argument
            state.largs.add(arg);
        }
    }
}