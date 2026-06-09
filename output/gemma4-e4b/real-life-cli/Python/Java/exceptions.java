import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// --- Utility/Mock Classes (Assuming these exist in the project structure) ---
/** Mock class for gettext functionality */
class I18n {
    public static String format(String pattern, Object... args) {
        if (args == null || args.length == 0) return pattern;
        // Simple placeholder implementation for formatting
        return String.format(pattern, args);
    }

    public static String gettext(String message) {
        return message; // Mock translation lookup
    }

    /** Simulates ngettext: "Did you mean {possibility}?" vs "(Possible options: {possibilities})" */
    public static String ngettext(String msgid, String plural, int count, Object... args) {
        // Simplified logic for demonstration. In a real app, this would handle plurals.
        return String.format(msgid, args); 
    }
}

/** Mock class for utility functions */
class Utils {
    public static void echo(String message, PrintStream file) {
        if (file != null) {
            file.println(message);
        } else {
            System.out.println(message);
        }
    }

    public static String formatFilename(String filename) {
        return filename; // Mock implementation
    }
}

/** Mock class for compatibility/IO */
class Compat {
    private static PrintStream getTextStderr() {
        return System.err;
    }
}

// --- Core Exception Classes ---

abstract class ClickException extends RuntimeException {
    protected final String message;
    public static final int EXIT_CODE = 1;

    public ClickException(String message) {
        super(message);
        this.message = message;
    }

    public String formatMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    /**
     * Displays the error message to the specified stream (defaulting to stderr).
     */
    public void show(PrintStream file) {
        if (file == null) {
            file = Compat.getTextStderr();
        }
        Utils.echo(I18n.format("Error: {message}", this.formatMessage()), file);
    }
}

class UsageError extends ClickException {
    protected final Context context;

    public UsageError(String message, Context ctx) {
        super(message);
        this.context = ctx;
    }

    @Override
    public void show(PrintStream file) {
        if (file == null) {
            file = Compat.getTextStderr();
        }
        
        String hint = "";
        boolean hasHint = false;

        // Check for help option hint
        if (this.context != null && this.context.getCommand().getHelpOption(this.context) != null) {
            hint = I18n.format("Try '{command} {option}' for help.", 
                this.context.getCommandPath(), this.context.getHelpOptionNames().get(0));
            hint += "\n";
            hasHint = true;
        }

        String usageOutput = "";
        if (this.context != null) {
            // Assuming Context has a getUsage() method returning the formatted usage string
            usageOutput = this.context.getUsage() + "\n" + hint;
        }

        // Note: Color handling is complex to translate without knowing the underlying terminal library. 
        // We skip explicit color logic but maintain structure.
        Utils.echo(usageOutput, file);
        
        // Display error message
        Utils.echo(I18n.format("Error: {message}", this.formatMessage()), file);
    }
}

class BadParameter extends UsageError {
    private final Parameter param;
    private final String paramHint;

    public BadParameter(String message, Context ctx, Parameter param, String paramHint) {
        super(message, ctx);
        this.param = param;
        this.paramHint = paramHint;
    }

    @Override
    public String formatMessage() {
        String effectiveParamHint = this.paramHint;
        if (effectiveParamHint == null) {
            if (this.param != null) {
                // Assuming Parameter has a getErrorHint method
                effectiveParamHint = this.param.getErrorHint(this.context);  
            } else {
                return I18n.format("Invalid value: {message}", this.message);
            }
        }

        String joinedHint = joinParamHints(effectiveParamHint);
        
        // Return "Invalid value for {param_hint}: {message}"
        return I18n.format("Invalid value for {param_hint}: {message}", 
                joinedHint, this.message);
    }

    private String joinParamHints(String paramHint) {
        if (paramHint == null || paramHint.isEmpty()) return "";
        // Simplified joining logic assuming the hint is already a string representation of multiple items
        return paramHint; 
    }
}


class MissingParameter extends BadParameter {
    private final String paramType;

    public MissingParameter(String message, Context ctx, Parameter param, String paramHint, String paramType) {
        super(message != null ? message : "", ctx, param, paramHint);
        this.paramType = paramType;
    }

    @Override
    public String formatMessage() {
        String effectiveParamHint = this.paramHint;
        if (effectiveParamHint == null) {
            if (this.param != null) {
                effectiveParamHint = this.param.getErrorHint(this.context);  
            } else {
                effectiveParamHint = null;
            }
        }

        String joinedHint = joinParamHints(effectiveParamHint);
        String formattedHint = (joinedHint != null && !joinedHint.isEmpty()) ? " " + joinedHint : "";


        // Determine param_type name
        String determinedParamType = this.paramType;
        if (determinedParamType == null && this.param != null) {
            // Assuming Parameter has a getParamTypeName method
            determinedParamType = this.param.getParamTypeName(); 
        }

        String msg = this.message;
        if (this.param != null) {
            // Assuming Parameter type has a getMissingMessage method
            String extraMsg = this.param.getType().getMissingMessage(this.param);
            if (extraMsg != null && !extraMsg.isEmpty()) {
                if (msg != null && !msg.isEmpty()) {
                    msg += ". " + extraMsg;
                } else {
                    msg = extraMsg;
                }
            }
        }

        String finalMsg = (msg != null && !msg.isEmpty()) ? " " + msg : "";


        // Determine missing type string
        String missing;
        if ("argument".equals(determinedParamType)) {
            missing = I18n.gettext("Missing argument");
        } else if ("option".equals(determinedParamType)) {
            missing = I18n.gettext("Missing option");
        } else if ("parameter".equals(determinedParamType)) {
            missing = I18n.gettext("Missing parameter");
        } else {
            missing = I18n.format("Missing {param_type}", determinedParamType);
        }

        // Final format: "{missing}{param_hint}.{msg}"
        return missing + formattedHint + "." + finalMsg;
    }

    @Override
    public String toString() {
        if (this.message == null || this.message.isEmpty()) {
            String paramName = this.param != null ? this.param.getName() : null;
            return I18n.format("Missing parameter: {param_name}", paramName);
        } else {
            return this.message;
        }
    }

    private String joinParamHints(String paramHint) {
        if (paramHint == null || paramHint.isEmpty()) return "";
        // Simplified joining logic
        return paramHint; 
    }
}


class NoSuchOption extends UsageError {
    private final String optionName;
    private final List<String> possibilities;

    public NoSuchOption(String optionName, String message, List<String> possibilities, Context ctx) {
        super(message, ctx);
        this.optionName = optionName;
        this.possibilities = possibilities != null ? possibilities : java.util.Collections.emptyList();
    }

    @Override
    public String formatMessage() {
        if (this.possibilities.isEmpty()) {
            return super.formatMessage(); // Use default message
        }

        // Sort and join possibilities
        String possibilityStr = this.possibilities.stream().sorted().collect(Collectors.joining(", "));
        
        // ngettext usage: "Did you mean {possibility}?" (msgid), "(Possible options: {possibilities})" (plural)
        String suggest = I18n.ngettext("Did you mean {possibility}?", 
                                      "(Possible options: {possibilities})", 
                                      this.possibilities.size(), 
                                      possibilityStr, possibilityStr);
        
        return super.formatMessage() + " " + suggest;
    }
}

class BadOptionUsage extends UsageError {
    private final String optionName;

    public BadOptionUsage(String optionName, String message, Context ctx) {
        super(message, ctx);
        this.optionName = optionName;
    }
}

class BadArgumentUsage extends UsageError {
    // No specific fields needed beyond calling super constructor with message/context
    public BadArgumentUsage(String message, Context ctx) {
        super(message, ctx);
    }
}


class FileError extends ClickException {
    private final String uiFilename;
    private final String filename;

    public FileError(String filename, String hint) {
        if (hint == null) {
            hint = I18n.gettext("unknown error");
        }
        super(hint);
        this.uiFilename = Utils.formatFilename(filename);
        this.filename = filename;
    }

    @Override
    public String formatMessage() {
        // Using Java's built-in representation for file names (equivalent to Python's !r)
        return I18n.format("Could not open file {filename!r}: {message}", 
                this.uiFilename, this.message);
    }
}

class Abort extends RuntimeException {
    public Abort(String message) {
        super(message);
    }
}

class Exit extends RuntimeException {
    private final int exitCode;

    public Exit(int code) {
        this.exitCode = code;
    }

    public int getExitCode() {
        return exitCode;
    }
}


// --- Mock Context/Parameter Classes for Compilation ---
/** Represents the CLI context */
class Context {
    private String commandPath = "cli";
    private String color = "";
    private List<String> helpOptionNames = Arrays.asList("help");

    public Command getCommand() { return new Command(); }
    public String getUsage() { return "usage output..."; }
    public String getCommandPath() { return commandPath; }
    public List<String> getHelpOptionNames() { return helpOptionNames; }
    public String getColor() { return color; }

    // Mock setters/getters for demonstration purposes
}

/** Represents the CLI Command */
class Command {
    public Object getHelpOption(Context ctx) { return null; } // Mock check
    public String getCommandPath() { return "cli"; }
}

/** Represents a parameter definition */
class Parameter {
    private final String name = "param";
    private final Type type = new Type();

    public String getName() { return name; }
    public Type getType() { return type; }
    public String getErrorHint(Context ctx) { return "[hint]"; } // Mock hint generation
    public String getParamTypeName() { return "parameter"; } 
}

/** Represents the parameter type */
class Type {
    public String getMissingMessage(Parameter param) { return null; } // Mock message
}