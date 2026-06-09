import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Click {

    public static final String VERSION = "8.1";

    // Enums for parameter sources
    enum ParameterSource {
        COMMANDLINE,
        ENVIRONMENT,
        DEFAULT,
        DEFAULT_MAP,
        PROMPT
    }

    // Base exception classes
    abstract static class ClickException extends Exception {
        protected int exitCode;
        
        public ClickException(String message) {
            super(message);
        }
        
        public void show() throws SystemExitException {
            throw new SystemExitException(exitCode, this.getMessage());
        }
    }

    static class Abort extends ClickException {
        public Abort() {
            super("Aborted!");
        }
    }

    static class BadParameter extends ClickException {
        @Nullable private Parameter param;
        
        public BadParameter(String message) {
            super(message);
        }
        
        public void setParam(Parameter p) {
            this.param = p;
        }
    }

    static class Exit extends RuntimeException {
        protected int exitCode;
        
        public Exit(int code) {
            this.exitCode = code;
        }
    }

    static class MissingParameter extends ClickException {}
    
    static class UsageError extends ClickException {}

    // Context manager for usage errors
    @FunctionalInterface
    interface AugmentUsageErrorsContextManager<T> {
        T augment(Click.Context ctx, Parameter param);
    }

    // Base command classes
    abstract static class Command implements Callable<Object> {
        
        protected String name;
        protected List<Parameter> params = new ArrayList<>();
        @Nullable private Object callback;
        @Nullable private String help;
        @Nullable private String epilog;
        @Nullable private String shortHelp;
        protected boolean addHelpOption = true;
        protected boolean noArgsIsHelp = false;
        protected boolean hidden = false;
        protected boolean deprecated = false;

        public Command(String name) {
            this.name = name;
        }

        abstract List<Parameter> getParams(Click.Context ctx);
        
        abstract String formatUsage(Click.Context ctx, HelpFormatter formatter);
        
        abstract void invoke(Click.Context ctx);
    }

    static class MultiCommand extends Command implements Iterable<String> {
        protected boolean chain = false;
        @Nullable private Object resultCallback;
        protected List<MultiCommand.CommandInfo> commands = new ArrayList<>();
        
        public String listCommands() {
            return ""; // Implementation depends on actual command storage
        }

        public MultiCommand getCommand(String name) {
            for (var cmd : this.commands) {
                if (cmd.name.equals(name)) {
                    return cmd;
                }
            }
            return null;
        }
    }

    static class Group extends MultiCommand {}

    // Parameter classes
    abstract static class Parameter implements Comparable<Parameter> {
        
        @Nullable private String name;
        protected List<String> opts = new ArrayList<>();
        protected List<String> secondaryOpts = new ArrayList<>();
        protected ParamType type;
        protected boolean required = false;
        @Nullable private Object defaultVal;
        @Nullable private ParameterCallback callback;
        protected int nargs = 1;
        protected boolean multiple = false;
        protected String metavar;
        protected boolean exposeValue = true;
        protected boolean isEager = false;
        
        public abstract void addOption(Click.OptionParser parser, Click.Context ctx);

        @Override
        public int compareTo(Parameter other) {
            return 0; // Default ordering
        }
    }

    static class Option extends Parameter implements Comparable<Option> {
        protected boolean isFlag = false;
        protected Object flagValue;
        protected boolean count = false;
        
        @Override
        public int compareTo(Option other) {
            return 0;
        }
    }

    static class Argument extends Parameter {}

    // Context class
    static class Context implements AutoCloseable {
        
        private Command command;
        @Nullable private Click.Context parent;
        protected Map<String, Object> params = new HashMap<>();
        protected List<Object> args = new ArrayList<>();
        protected String infoName;
        @Nullable private Object obj;
        @Nullable private String autoEnvvarPrefix;
        
        public Context(Command command) {
            this.command = command;
        }

        @Override
        public void close() throws Exception {
            // Cleanup resources if needed
        }
    }

    static class HelpFormatter {
        protected int width = 80;
        protected String maxWidth;
        
        public void writeUsage(String path, List<String> pieces) {}
        
        public void writeText(String text) {}
        
        public void writeParagraph() {}
        
        public void section(String title) {}
    }

    // Main entry point simulation
    static class ClickApp {
        
        private Command command;
        @Nullable private String progName;
        
        public ClickApp(Command cmd, String name) {
            this.command = cmd;
            this.progName = name;
        }

        public Object main(String[] args) throws Exception {
            // Simulate the click.main() behavior
            return command.invoke(new Context(command));
        }
    }

    static class OptionParser {
        
        protected List<String> _optPrefixes = new ArrayList<>();
        
        public void addOption(Object obj, String[] opts, String dest) {}
        
        public Object parseArgs(List<String> args) throws Exception {
            // Parse implementation
            return null;
        }
    }

    static class ShellCompletionItem implements Comparable<ShellCompletionItem> {
        private String name;
        @Nullable private String help;
        
        public ShellCompletionItem(String name, @Nullable String help) {
            this.name = name;
            this.help = help;
        }
        
        @Override
        public int compareTo(ShellCompletionItem other) {
            return this.name.compareTo(other.name);
        }
    }

    // Utility functions (simplified versions)
    
    static String makeStr(Object obj) {
        if (obj == null) return "";
        return obj.toString();
    }

    static void echo(String message, @Nullable Object file) throws IOException {
        System.out.println(message);
    }

    // Main class for the CLI application
    public static class CliApp extends Command {
        
        private String name;
        protected List<Parameter> params = new ArrayList<>();
        @Nullable private Callable<Object> callback;
        @Nullable private Click.Context context;
        
        public CliApp(String name, @Nullable Callable<Object> cb) {
            super(name);
            this.callback = cb != null ? cb : () -> {};
        }

        @Override
        List<Parameter> getParams(Click.Context ctx) {
            return params;
        }

        @Override
        String formatUsage(Click.Context ctx, HelpFormatter formatter) {
            // Format usage implementation
            return "";
        }

        @Override
        void invoke(Click.Context ctx) throws Exception {
            if (callback != null) {
                callback.call();
            }
        }
    }

    public static class CliGroup extends MultiCommand implements Iterable<String> {
        
        private Map<String, Command> commands = new HashMap<>();
        
        @Override
        List<Parameter> getParams(Click.Context ctx) {
            return params;
        }

        @Override
        String formatUsage(Click.Context ctx, HelpFormatter formatter) {
            // Format usage implementation for groups
            return "";
        }

        public void addCommand(Command cmd, @Nullable String name) throws Exception {
            if (name == null && cmd.name != null) {
                this.commands.put(cmd.name, cmd);
            } else if (name != null) {
                this.commands.put(name, cmd);
            }
        }

        public Command getCommand(String name) {
            return commands.getOrDefault(name, null);
        }

        @Override
        List<String> listCommands() {
            return new ArrayList<>(commands.keySet());
        }
    }

}