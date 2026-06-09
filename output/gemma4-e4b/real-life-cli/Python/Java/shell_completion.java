import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// --- Placeholder/Mock Classes for Dependencies ---
// In a real translation, these would be fully implemented.
class Argument {}
class BaseCommand {
    public Context makeContext(String name, List<String> args, Object parent, boolean resilientParsing) { return null; }
    public Command getCommand() { return null; } // Mock method for context access
}
class MultiCommand {
    public Map.Entry<String, Command>[] resolveCommand(Context ctx, List<String> args) { return new HashMap<Map.Entry<String, Command>>().entrySet().toArray(new Map.Entry[0]); }
}
class Option {}
class Parameter {}
class Context {
    private final Map<String, Object> params = new HashMap<>();
    public void setParameter(String name, Object value) { this.params.put(name, value); }
    public Optional<Object> getParameter(String name) { return Optional.ofNullable(this.params.get(name)); }
    public ParameterSource getParameterSource(String name) { return null; } // Mock implementation
    public List<Parameter> getParams(Context ctx) { return Collections.emptyList(); } // Mock implementation
}
enum ParameterSource { COMMANDLINE }

class Utils {
    public static void echo(String s) { System.out.println(s); }
}

// Utility functions/constants placeholders
class ParserUtils {
    public static List<String> splitArgString(String envVar) { return Arrays.asList("arg1", "arg2"); }
}

// Mocking gettext functionality
class I18n {
    public static String _(String s) { return s; }
}

// --- Core Logic Classes ---

/**
 * Represents a single completion item.
 */
class CompletionItem {
    private final Object value;
    private final String type;
    private final String help;
    private final Map<String, Object> info;

    public CompletionItem(Object value, String type, String help, Map<String, Object> kwargs) {
        this.value = value;
        this.type = type != null ? type : "plain";
        this.help = help;
        this.info = new HashMap<>(kwargs);
    }

    public Object getValue() { return value; }
    public String getType() { return type; }
    public String getHelp() { return help; }

    // Mimicking __getattr__ behavior for info access
    public Optional<Object> getInfo(String name) {
        return Optional.ofNullable(info.get(name));
    }
}

/**
 * Abstract base class for shell completion logic.
 */
abstract class ShellComplete {
    private static final String NAME = "shell"; // Placeholder, actual names are set in subclasses

    protected abstract String getSourceTemplate();

    public BaseCommand cli;
    public Map<String, Object> ctxArgs;
    public String progName;
    public String completeVar;

    public ShellComplete(BaseCommand cli, Map<String, Object> ctxArgs, String progName, String completeVar) {
        this.cli = cli;
        this.ctxArgs = new HashMap<>(ctxArgs); // Defensive copy
        this.progName = progName;
        this.completeVar = completeVar;
    }

    public String getFuncName() {
        String safeName = progName.replaceAll("[^a-zA-Z0-9_]", "");
        return "_" + safeName + "_completion";
    }

    public Map<String, Object> sourceVars() {
        Map<String, Object> vars = new HashMap<>();
        vars.put("complete_func", getFuncName());
        vars.put("complete_var", this.completeVar);
        vars.put("prog_name", this.progName);
        return vars;
    }

    public String source() {
        // In Java, we use String.format or Map replacement logic instead of Python's % operator
        String template = getSourceTemplate();
        Map<String, Object> vars = sourceVars();
        
        // Simple placeholder replacement for demonstration (assuming keys match placeholders)
        String result = template;
        for (Map.Entry<String, Object> entry : vars.entrySet()) {
            result = result.replace("${" + entry.getKey() + "}", entry.getValue().toString());
        }
        return result;
    }

    public abstract List<String> getCompletionArgs(); // Returns list of arguments (e.g., COMP_WORDS)
    public abstract String getIncomplete();     // Returns the incomplete word (e.g., COMP_CWORD)

    public List<CompletionItem> getCompletions(List<String> args, String incomplete) {
        Context ctx = resolveContext(this.cli, this.ctxArgs, this.progName, args);
        Object obj = null; // Placeholder for resolved object/command
        String finalIncomplete = incomplete;

        // Mocking _resolve_incomplete logic: In a real scenario, we'd need the full context to resolve 'obj'.
        // For translation purposes, we assume resolution happens and returns an object that has shellComplete(ctx, incomplete) method.
        // Since we cannot replicate complex Python runtime behavior here, we mock the result structure.

        // Assuming obj is a placeholder for the resolved command/object:
        if (this instanceof BashComplete) {
            obj = this; // Self-reference for simplicity in mocking
        } else if (this instanceof ZshComplete) {
            obj = this;
        } else if (this instanceof FishComplete) {
            obj = this;
        }

        // Mocking the call to shell_complete logic:
        return ((ShellComplete) obj).shellComplete(ctx, finalIncomplete);
    }

    public abstract String formatCompletion(CompletionItem item);

    public String complete() {
        List<String> args = getCompletionArgs();
        String incomplete = getIncomplete();
        
        List<CompletionItem> completions = getCompletions(args, incomplete);
        StringBuilder sb = new StringBuilder();
        for (CompletionItem item : completions) {
            sb.append(formatCompletion(item)).append("\n");
        }
        return sb.toString().trim();
    }

    // --- Utility Methods translated from Python functions ---

    protected Context resolveContext(BaseCommand cli, Map<String, Object> ctxArgs, String progName, List<String> args) {
        // This is a highly complex function involving command resolution and context chaining.
        // We provide a structural mock implementation.
        System.out.println("Resolving context...");
        return new Context(); // Return a mocked context
    }

    /**
     * Mocking the shell_complete logic structure from Python's top-level function.
     */
    public List<CompletionItem> shellComplete(Context ctx, String incomplete) {
        String[] parts = incomplete.split("_");
        if (parts.length < 2) return Collections.emptyList();

        String shell = parts[0];
        // In Python: comp_cls = get_completion_class(shell)
        // Since this method is called *on* the class instance, we assume the correct logic path was taken.

        if ("source".equals(parts[1])) {
            Utils.echo(this.source());
            return Collections.emptyList(); // Signal success via echo
        } else if ("complete".equals(parts[1])) {
            Utils.echo(this.complete());
            return Collections.emptyList(); // Signal success via echo
        }

        return Collections.emptyList(); // Failure signal
    }
}


/**
 * Bash completion implementation.
 */
class BashComplete extends ShellComplete {
    private static final String NAME = "bash";
    private static final String SOURCE_TEMPLATE = "#!/bin/bash\n# Source template for bash";

    public BashComplete(BaseCommand cli, Map<String, Object> ctxArgs, String progName, String completeVar) {
        super(cli, ctxArgs, progName, completeVar);
    }

    private void checkVersion() throws RuntimeException {
        try {
            // Equivalent to subprocess.run(["bash", "-c", 'echo "${BASH_VERSION}"'])
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", "echo \"$BASH_VERSION\"");
            Process process = pb.start();
            String output = readStream(process.getInputStream());
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                throw new RuntimeException("Failed to execute bash version check.");
            }

            // Regex matching logic: r"^(\d+)\.(\d+)\.\d+"
            Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.\\d+");
            Matcher matcher = pattern.matcher(output);

            if (matcher.find()) {
                String major = matcher.group(1);
                String minor = matcher.group(2);

                // Version comparison logic: Major < 4 OR (Major == 4 AND Minor < 4)
                int majorInt = Integer.parseInt(major);
                int minorInt = Integer.parseInt(minor);

                if (majorInt < 4 || (majorInt == 4 && minorInt < 4)) {
                    throw new RuntimeException(I18n._("Shell completion is not supported for Bash versions older than 4.4."));
                }
            } else {
                throw new RuntimeException(I18n._("Couldn't detect Bash version, shell completion is not supported."));
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error checking bash version.", e);
        }
    }
    
    private String readStream(java.io.InputStream inputStream) throws IOException {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    @Override
    public String source() {
        try {
            checkVersion();
        } catch (RuntimeException e) {
            // Handle failure gracefully, perhaps by returning an error message or empty string
            System.err.println("Error sourcing bash completion: " + e.getMessage());
        }
        return super.source();
    }

    @Override
    public List<String> getCompletionArgs() {
        // Mocking os.environ access for COMP_WORDS and COMP_CWORD
        List<String> cwords = ParserUtils.splitArgString(System.getenv("COMP_WORDS"));
        int cwordIndex;
        try {
            cwordIndex = Integer.parseInt(System.getenv("COMP_CWORD"));
        } catch (NumberFormatException e) {
            return Collections.emptyList();
        }

        // args = cwords[1:cword]
        List<String> args = cwords.subList(1, Math.min(cwordIndex, cwords.size()));

        // incomplete = cwords[cword]
        String incomplete;
        if (cwordIndex < cwords.size()) {
            incomplete = cwords.get(cwordIndex);
        } else {
            incomplete = "";
        }

        return Arrays.asList(args, incomplete); // Returning both lists/strings for simplicity in the mock structure
    }

    @Override
    public String getIncomplete() {
        // Assuming the last element of the list returned by getCompletionArgs is the incomplete word
        List<String> args = getCompletionArgs();
        if (args.isEmpty()) return "";
        return args.get(args.size() - 1);
    }

    @Override
    public String formatCompletion(CompletionItem item) {
        return item.getType() + "," + item.getValue().toString();
    }
}


/**
 * Zsh completion implementation.
 */
class ZshComplete extends ShellComplete {
    private static final String NAME = "zsh";
    private static final String SOURCE_TEMPLATE = "#!/bin/zsh\n# Source template for zsh";

    public ZshComplete(BaseCommand cli, Map<String, Object> ctxArgs, String progName, String completeVar) {
        super(cli, ctxArgs, progName, completeVar);
    }

    @Override
    public List<String> getCompletionArgs() {
        // Mocking os.environ access for COMP_WORDS and COMP_CWORD
        List<String> cwords = ParserUtils.splitArgString(System.getenv("COMP_WORDS"));
        int cwordIndex;
        try {
            cwordIndex = Integer.parseInt(System.getenv("COMP_CWORD"));
        } catch (NumberFormatException e) {
            return Collections.emptyList();
        }

        // args = cwords[1:cword]
        List<String> args = cwords.subList(1, Math.min(cwordIndex, cwords.size()));

        // incomplete = cwords[cword]
        String incomplete;
        if (cwordIndex < cwords.size()) {
            incomplete = cwords.get(cwordIndex);
        } else {
            incomplete = "";
        }

        return Arrays.asList(args, incomplete);
    }

    @Override
    public String getIncomplete() {
        List<String> args = getCompletionArgs();
        if (args.isEmpty()) return "";
        return args.get(args.size() - 1);
    }

    @Override
    public String formatCompletion(CompletionItem item) {
        // Note: Python uses \n for newlines, which is preserved here.
        String help = Optional.ofNullable(item.getInfo("help")).map(Object::toString).orElse("_");
        return item.getType() + "\n" + item.getValue().toString() + "\n" + help;
    }
}

/**
 * Fish completion implementation.
 */
class FishComplete extends ShellComplete {
    private static final String NAME = "fish";
    private static final String SOURCE_TEMPLATE = "#!/bin/fish\n# Source template for fish";

    public FishComplete(BaseCommand cli, Map<String, Object> ctxArgs, String progName, String completeVar) {
        super(cli, ctxArgs, progName, completeVar);
    }

    @Override
    public List<String> getCompletionArgs() {
        // Mocking os.environ access for COMP_WORDS and COMP_CWORD
        List<String> cwords = ParserUtils.splitArgString(System.getenv("COMP_WORDS"));
        String incomplete = System.getenv("COMP_CWORD");
        
        // args = cwords[1:] (All words after the first)
        List<String> args = cwords.subList(1, cwords.size());

        // Logic: if incomplete and args and args[-1] == incomplete: args.pop()
        if (incomplete != null && !args.isEmpty() && args.get(args.size() - 1).equals(incomplete)) {
            args = new ArrayList<>(args.subList(0, args.size() - 1)); // Pop the last element
        }

        return Arrays.asList(args, incomplete);
    }

    @Override
    public String getIncomplete() {
        // Assuming the last element of the list returned by getCompletionArgs is the incomplete word
        List<String> args = getCompletionArgs();
        if (args.isEmpty()) return "";
        return args.get(args.size() - 1);
    }

    @Override
    public String formatCompletion(CompletionItem item) {
        Optional<Object> helpObj = item.getInfo("help");
        String help = helpObj.isPresent() ? (String) helpObj.get() : null;

        if (help != null) {
            return item.getType() + "," + item.getValue().toString() + "\t" + help;
        }
        return item.getType() + "," + item.getValue().toString();
    }
}


/**
 * Main class containing utility functions and the registry map.
 */
public class CompletionManager {

    // Mocking Python's TypeVar/ClassVar structure using Java Map<String, Class<? extends ShellComplete>>
    private static final Map<String, Class<? extends ShellComplete>> AVAILABLE_SHELLS = new HashMap<>();

    static {
        AVAILABLE_SHELLS.put("bash", BashComplete.class);
        AVAILABLE_SHELLS.put("fish", FishComplete.class);
        AVAILABLE_SHELLS.put("zsh", ZshComplete.class);
    }

    public static <T extends ShellComplete> T addCompletionClass(Class<T> cls, String name) {
        if (name == null) {
            // Attempt to derive name from class structure if needed, otherwise use a default
            name = "unknown"; 
        }
        AVAILABLE_SHELLS.put(name, cls);
        try {
            return cls.getDeclaredConstructor(BaseCommand.class, Map.class, String.class, String.class)
                    .newInstance(null, null, null, null); // Return an instance for type safety in the mock context
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate completion class: " + name, e);
        }
    }

    public static Optional<ShellComplete> getCompletionClass(String shell) {
        Class<? extends ShellComplete> cls = AVAILABLE_SHELLS.get(shell);
        if (cls == null) {
            return Optional.empty();
        }
        try {
             // Instantiate the class dynamically, passing necessary mocks/placeholders
            return Optional.of((ShellComplete) cls.getDeclaredConstructor(BaseCommand.class, Map.class, String.class, String.class).newInstance(null, null, null, null));
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate completion class for " + shell, e);
        }
    }

    // --- Utility Functions Translation ---

    public static boolean isCompleteArgument(Context ctx, Parameter param) {
        if (!(param instanceof Argument)) {
            return false;
        }

        // Assuming param has a getName() method
        String name = "mock_name"; // Placeholder for param.getName()
        
        Object value = ctx.getParameter(name).orElse(null);
        
        boolean isNargsMinusOne = (param.nargs == -1);
        boolean sourceIsNotCommandLine = (ctx.getParameterSource(name) != ParameterSource.COMMANDLINE);

        if (isNargsMinusOne || sourceIsNotCommandLine) {
            // Mocking type checking for tuple/list length
            if (param.nargs > 1 && value instanceof Collection) {
                Collection<?> col = (Collection<?>) value;
                return ((Integer) param.nargs > col.size()); // Simplified check
            }
        }
        return false;
    }

    public static boolean startOfOption(Context ctx, String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        char c = value.charAt(0);
        // Assuming Context has an internal set of option prefixes
        return ctx.getOptPrefixes().contains(String.valueOf(c)); 
    }

    public static boolean isIncompleteOption(Context ctx, List<String> args, Parameter param) {
        if (!(param instanceof Option)) {
            return false;
        }

        // Assuming Option has methods for isFlag() and count()
        boolean isFlagOrCount = ((Option) param).isFlag() || ((Option) param).getCount() > 0;
        if (isFlagOrCount) {
            return false;
        }

        String lastOption = null;
        int nargs = param.nargs(); // Assuming getter for nargs

        for (int i = args.size() - 1; i >= 0; i--) {
            int indexPlusOne = args.size() - i;
            if (indexPlusOne > nargs) {
                break;
            }

            String arg = args.get(i);
            if (startOfOption(ctx, arg)) {
                lastOption = arg;
            }
        }

        return lastOption != null && ((Option) param).getOptions().contains(lastOption);
    }

    public static Context resolveContext(BaseCommand cli, Map<String, Object> ctxArgs, String progName, List<String> args) {
        // Implementation remains structural mock due to complexity.
        ctxArgs.put("resilient_parsing", true);
        Context ctx = cli.makeContext(progName, new ArrayList<>(args), null, true);
        List<String> currentArgs = new ArrayList<>(ctx.getProtectedArgs());
        currentArgs.addAll(ctx.getArgs());

        // Simplified loop structure mock
        while (!currentArgs.isEmpty()) {
            MultiCommand command = (MultiCommand) ctx.getCommand(); // Assuming MultiCommand getter exists
            if (command != null && !command.chain().isEmpty()) {
                // Complex multi-command resolution logic skipped for brevity/mocking
                break; 
            } else {
                break;
            }
        }

        return ctx;
    }

    public static AbstractMap.SimpleEntry<BaseCommand, Parameter> resolveIncomplete(Context ctx, List<String> args, String incomplete) {
        // Mocking the return type: Pair of (Resolved Object/Command, Incomplete Word)
        
        String tempIncomplete = incomplete;
        if ("=".equals(incomplete)) {
            tempIncomplete = "";
        } else if (incomplete != null && incomplete.contains("=") && startOfOption(ctx, incomplete)) {
            // Logic to split name and update args list
            String[] parts = incomplete.split("=");
            String name = parts[0];
            args.add(name);
            tempIncomplete = ""; // Assuming the logic handles this reset
        }

        if (!args.contains("--") && startOfOption(ctx, tempIncomplete)) {
             // Return command and incomplete word
             return new AbstractMap.SimpleEntry<>(null, null); // Mock return
        }

        List<Parameter> params = ctx.getCommand().getParams(ctx);

        for (Parameter param : params) {
            if (isIncompleteOption(ctx, args, param)) {
                // Return parameter and incomplete word
                return new AbstractMap.SimpleEntry<>(null, null); // Mock return
            }
        }

        for (Parameter param : params) {
            if (isCompleteArgument(ctx, param)) {
                 // Return parameter and incomplete word
                return new AbstractMap.SimpleEntry<>(null, null); // Mock return
            }
        }

        // Default fallback: command and original incomplete word
        return new AbstractMap.SimpleEntry<>(null, null); 
    }
}