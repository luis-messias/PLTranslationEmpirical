import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Click {
    
    public interface Context {}
    
    public interface Command extends Runnable, MethodHandleHolder {}
    
    public static class Group implements Runnable, MethodHandleHolder {}
    
    public abstract class Option<T> implements Parameter<T> {}
    
    public abstract class Argument<T> implements Parameter<T> {}
    
    public abstract class Parameter<T> {
        protected String name;
        
        @Override
        public void setParameterName(String name) {
            this.name = name;
        }
    }
    
    public static <T, P extends java.util.function.Consumer<Context>> 
           ContextDecorator passContext(P callback) throws Exception {
        return new ContextDecorator(callback);
    }
    
    private static class ContextDecorator<T> implements Runnable {
        
        @Override
        public void run() {}
        
        protected T getCallback() {
            throw new UnsupportedOperationException();
        }
    }
    
    public interface CommandBuilder<T extends Command> {
        T build(String name, Method callback);
    }
    
    public static <T extends Command> 
           CommandDecorator command(Class<? extends T> cls) throws Exception {
        return new CommandDecorator<>(cls);
    }
    
    private static class CommandDecorator<T extends Command> implements Runnable {
        
        @Override
        public void run() {}
        
        protected Class<?> getCommandClass() {
            throw new UnsupportedOperationException();
        }
    }
    
    public interface GroupBuilder<T extends Group> {
        T build(String name, Method callback);
    }
    
    public static <T extends Group> 
           GroupDecorator group(Class<? extends T> cls) throws Exception {
        return new GroupDecorator<>(cls);
    }
    
    private static class GroupDecorator<T extends Group> implements Runnable {
        
        @Override
        public void run() {}
        
        protected Class<?> getGroupClass() {
            throw new UnsupportedOperationException();
        }
    }
    
    public interface ArgumentBuilder<T extends Argument<?>> {
        T build(String name, Method callback);
    }
    
    public static <T> 
           OptionDecorator argument(Class<? extends T> cls) throws Exception {
        return new OptionDecorator<>(cls);
    }
    
    private static class OptionDecorator<T extends Option<?>> implements Runnable {
        
        @Override
        public void run() {}
        
        protected Class<?> getOptionClass() {
            throw new UnsupportedOperationException();
        }
    }
    
    public interface PasswordOptionBuilder {
        T build(String name, Method callback);
    }
    
    public static <T> 
           OptionDecorator passwordOption(Class<? extends T> cls) throws Exception {
        return new OptionDecorator<>(cls);
    }
    
    private static class VersionCallback implements Runnable {
        
        @Override
        public void run() {}
        
        protected String getVersion(String package_name, Method callback) {
            throw new UnsupportedOperationException();
        }
    }
    
    public interface HelpOptionBuilder {
        T build(String name, Method callback);
    }
    
    private static class ConfirmationCallback implements Runnable {
        
        @Override
        public void run() {}
        
        protected boolean isConfirmed(Method callback) throws Exception {
            throw new UnsupportedOperationException();
        }
    }
}

public interface Parameter<T> extends java.lang.reflect.Parameter {
    String getName();
    
    T getValue(Context context);
    
    default void setParameterName(String name) {
        // Implementation depends on concrete class
    }
}

public abstract class Option implements Parameter<Object> {
    protected boolean isFlag;
    protected Object callbackValue;
    
    @Override
    public String getName() {
        return "option";
    }
    
    @Override
    public Object getValue(Context context) {
        if (isFlag && !callbackValue != null) {
            throw new IllegalStateException("Option not set");
        }
        return callbackValue;
    }
}

public abstract class Argument implements Parameter<Object> {
    protected String name;
    
    @Override
    public String getName() {
        return "argument";
    }
    
    @Override
    public Object getValue(Context context) {
        throw new UnsupportedOperationException();
    }
}

public interface Context extends java.util.Map<String, Object> {}

public class Command implements Runnable {
    private final String name;
    private final Method callback;
    private final List<Parameter<?>> params = new ArrayList<>();
    
    public Command(String name, Method callback) throws Exception {
        this.name = name;
        this.callback = callback;
    }
    
    @Override
    public void run() {}
}

public class Group implements Runnable {
    private final String name;
    private final List<Command> commands = new ArrayList<>();
    
    public Group(String name) throws Exception {
        this.name = name;
    }
    
    @Override
    public void run() {}
}

public interface ContextDecorator<T extends Runnable, P extends java.util.function.Consumer<Context>> 
           implements T {
        
    default <R> R pass(Context context, Method callback) throws Exception {
        return (R) ((Runnable) this).run();
    }
    
    @Override
    public void run() {}
}

public class PasswordOptionBuilder<T extends Option<?>> {
    
    private static final String DEFAULT_PASSWORD = "--password";
    
    protected T build(String name, Method callback) throws Exception {
        return new Option<>();
    }
}

public interface VersionCallback implements Runnable {
    
    @Override
    public void run() {}
    
    default Object getVersion(Object package_name, Method callback) {
        throw new UnsupportedOperationException();
    }
}

public class HelpOptionBuilder<T extends Option<?>> {
    
    private static final String DEFAULT_HELP = "--help";
    
    protected T build(String name, Method callback) throws Exception {
        return new Option<>();
    }
}

public interface ConfirmationCallback implements Runnable {
    
    @Override
    public void run() {}
    
    default boolean isConfirmed(Method callback) throws Exception {
        throw new UnsupportedOperationException();
    }
}

public class ClickUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    public static <T> T invoke(Context context, Method method, Object... args) throws Exception {
        if (context == null || method == null) {
            throw new IllegalArgumentException("Context and method cannot be null");
        }
        
        return ((Runnable) method).run();
    }
    
    public static <T> T ensureObject(Context context, Class<T> type) throws Exception {
        if (context == null || type == null) {
            throw new IllegalArgumentException("Context and type cannot be null");
        }
        
        return ((Runnable) method).run();
    }
    
    public static <T> T findObject(Context context, Class<T> type) throws Exception {
        if (context == null || type == null) {
            throw new IllegalArgumentException("Context and type cannot be null");
        }
        
        return ((Runnable) method).run();
    }
}

public class ClickException extends RuntimeException {}

public interface MethodHandleHolder<T> implements Runnable, java.lang.reflect.MethodHandleHolder {
    
    @Override
    public void run() throws Exception;
    
    default Object handle(Object... args) throws Exception {
        return ((Runnable) this).run();
    }
}

public class ClickMetaKeyHandler<K extends String> {
    
    private final K key;
    private final String docDescription;
    
    public ClickMetaKeyHandler(K key, String docDescription) throws Exception {
        if (key == null || docDescription == null) {
            throw new IllegalArgumentException("Key and description cannot be null");
        }
        
        this.key = key;
        this.docDescription = docDescription;
    }
    
    public K getKey() {
        return key;
    }
}

public class ClickContext extends java.util.HashMap<String, Object> implements Context {}

public interface CommandBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface GroupBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface OptionBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface ArgumentBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface PasswordOptionBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface VersionOptionBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface HelpOptionBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public interface ConfirmationOptionBuilder<T extends Runnable> {
    
    T build(String name, Method callback) throws Exception;
    
    default void setCallback(Method method) throws Exception {
        if (method == null || !isRunnable(method)) {
            throw new IllegalArgumentException("Method must be runnable");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickVersionOptionBuilder implements VersionOptionBuilder<Runnable> {
    
    private static final String DEFAULT_VERSION = "--version";
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickHelpOptionBuilder implements HelpOptionBuilder<Runnable> {
    
    private static final String DEFAULT_HELP = "--help";
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickPasswordOptionBuilder implements PasswordOptionBuilder<Runnable> {
    
    private static final String DEFAULT_PASSWORD = "--password";
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickConfirmationOptionBuilder implements ConfirmationOptionBuilder<Runnable> {
    
    private static final String DEFAULT_CONFIRMATION = "--yes";
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickArgumentBuilder implements ArgumentBuilder<Runnable> {
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickOptionBuilder implements OptionBuilder<Runnable> {
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickCommandBuilder implements CommandBuilder<Runnable> {
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickGroupBuilder implements GroupBuilder<Runnable> {
    
    @Override
    public Runnable build(String name, Method callback) throws Exception {
        if (name == null || !isRunnable(callback)) {
            throw new IllegalArgumentException("Name and method cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickMetaKeyHandler<K extends String> implements java.lang.reflect.MethodHandleHolder, Runnable {
    
    private final K key;
    private final String docDescription;
    
    public ClickMetaKeyHandler(K key, String docDescription) throws Exception {
        if (key == null || docDescription == null) {
            throw new IllegalArgumentException("Key and description cannot be null");
        }
        
        this.key = key;
        this.docDescription = docDescription;
    }
    
    @Override
    public void run() {}
}

public class ClickContextDecorator<T extends Runnable, P extends java.util.function.Consumer<Context>> 
           implements T {
    
    private final Context context;
    private final Method callback;
    
    public ClickContextDecorator(Context context, Method callback) throws Exception {
        if (context == null || callback == null) {
            throw new IllegalArgumentException("Context and method cannot be null");
        }
        
        this.context = context;
        this.callback = callback;
    }
    
    @Override
    public void run() {}
}

public class ClickCommandDecorator<T extends Runnable> implements T, CommandBuilder<Runnable>, MethodHandleHolder {
    
    private final Class<?> commandClass;
    private final String name;
    private final List<Parameter<?>> params = new ArrayList<>();
    
    public ClickCommandDecorator(Class<? extends T> commandClass) throws Exception {
        if (commandClass == null || !isRunnable(commandClass)) {
            throw new IllegalArgumentException("Command class cannot be null");
        }
        
        this.commandClass = commandClass;
    }
    
    @Override
    public void run() {}
}

public class ClickGroupDecorator<T extends Runnable> implements T, GroupBuilder<Runnable>, MethodHandleHolder {
    
    private final Class<?> groupClass;
    private final String name;
    private final List<Command> commands = new ArrayList<>();
    
    public ClickGroupDecorator(Class<? extends T> groupClass) throws Exception {
        if (groupClass == null || !isRunnable(groupClass)) {
            throw new IllegalArgumentException("Group class cannot be null");
        }
        
        this.groupClass = groupClass;
    }
    
    @Override
    public void run() {}
}

public interface EchoHandler<T> extends java.util.function.Consumer<String>, Runnable {
    
    default T echo(String message) throws Exception {
        if (message == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Message and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickEchoHandler implements EchoHandler<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ExitContext<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements T {
        
    default <R> R exit(String message) throws Exception {
        if (message == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Message and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickExitContext implements ExitContext<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ColorHandler<T extends Runnable> extends EchoHandler<T>, Runnable {
    
    default T color(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickColorHandler implements ColorHandler<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface RootContext<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R findRoot(String infoName) throws Exception {
        if (infoName == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Info name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickRootContext implements RootContext<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ResilientParsing<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setResilient(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickResilientParsing implements ResilientParsing<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface MetadataHandler<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R getMetadata(String package_name) throws Exception {
        if (package_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Package name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickMetadataHandler implements MetadataHandler<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface PackageName<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R getPackageName(String package_name) throws Exception {
        if (package_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Package name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickPackageName implements PackageName<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ModuleType<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R getModule(String module_name) throws Exception {
        if (module_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Module name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickModuleType implements ModuleType<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface PackageNotFoundError<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R handleNotFound(String package_name) throws Exception {
        if (package_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Package name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickPackageNotFoundError implements PackageNotFoundError<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Version<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R getVersion(String package_name) throws Exception {
        if (package_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Package name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickVersion implements Version<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Message<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setMessage(String message) throws Exception {
        if (message == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Message and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickMessage implements Message<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ProgName<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setProgName(String prog_name) throws Exception {
        if (prog_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Program name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickProgName implements ProgName<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Callback<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setCallback(Method callback) throws Exception {
        if (callback == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Method and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickCallback implements Callback<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface IsFlag<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setIsFlag(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickIsFlag implements IsFlag<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ExposeValue<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setExpose(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickExposeValue implements ExposeValue<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface IsEager<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setIsEager(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickIsEager implements IsEager<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Help<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setHelp(String help) throws Exception {
        if (help == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Help and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickHelp implements Help<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Prompt<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setPrompt(String prompt) throws Exception {
        if (prompt == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Prompt and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickPrompt implements Prompt<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Confirmation<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setConfirmation(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickConfirmation implements Confirmation<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface HideInput<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setHide(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickHideInput implements HideInput<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ParamDecls<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setParamDecls(String... param_decls) throws Exception {
        if (param_decls == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Parameter declarations and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickParamDecls implements ParamDecls<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface CallbackHandler<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setCallback(Method callback) throws Exception {
        if (callback == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Method and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickCallbackHandler implements CallbackHandler<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Abort<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R abort(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickAbort implements Abort<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Value<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setValue(Object value) throws Exception {
        if (value == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Value and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickValue implements Value<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ParameterHandler<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setParameter(Parameter<?> param) throws Exception {
        if (param == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Parameter and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickParameterHandler implements ParameterHandler<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface ContextMap<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R put(String key, Object value) throws Exception {
        if (key == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Key and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickContextMap implements ContextMap<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Meta<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R getMeta(String key) throws Exception {
        if (key == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Key and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickMeta implements Meta<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Resilient<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setResilient(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickResilient implements Resilient<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface InfoName<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setInfo(String info_name) throws Exception {
        if (info_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Info name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickInfoName implements InfoName<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Color<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setColor(boolean enabled) throws Exception {
        if (enabled == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Enabled and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickColor implements Color<Runnable, java.util.function.Consumer<String>> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Package<T extends Runnable> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R setPackage(String package_name) throws Exception {
        if (package_name == null || !isRunnable(this)) {
            throw new IllegalArgumentException("Package name and handler cannot be null");
        }
        
        return ((Runnable) this).run();
    }
}

public class ClickPackage implements Package<Runnable> {
    
    private static final Logger logger = LoggerFactory.getLogger(Click.class);
    
    @Override
    public void run() {}
}

public interface Partition<T extends Runnable, P extends java.util.function.Consumer<String>> 
           implements ExitContext<T>, EchoHandler<P>, MethodHandleHolder {
        
    default <R> R partition(String package_name) throws Exception {
        if (package_name ==