import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

/**
 * Utility class for managing and retrieving the current execution context 
 * within a thread, mimicking Python's threading.local stack behavior.
 */
public final class ContextManager {

    // ThreadLocal to hold the stack of contexts for the current thread.
    private static final ThreadLocal<Stack<Context>> CONTEXT_STACK = 
            ThreadLocal.withInitial(Stack::new);

    private ContextManager() {
        // Utility class
    }

    /**
     * Retrieves the context currently at the top of the stack for this thread.
     * 
     * @param silent If true, returns Optional.empty() if no context is available, 
     *               instead of throwing an exception.
     * @return An Optional containing the current Context, or empty if none exists.
     */
    public static Optional<Context> getCurrentContext(boolean silent) {
        Stack<Context> stack = CONTEXT_STACK.get();

        if (stack == null || stack.isEmpty()) {
            if (!silent) {
                // Mimics the RuntimeError raised in Python if not silent
                throw new IllegalStateException("There is no active click context.");
            }
            return Optional.empty();
        }

        // Peek at the top element (the current context)
        Context currentContext = stack.peek();
        return Optional.of(currentContext);
    }

    /**
     * Overload for convenience when silent mode is desired.
     */
    public static Optional<Context> getCurrentContext() {
        return getCurrentContext(true);
    }


    /**
     * Pushes a new context onto the thread-local stack.
     * @param ctx The context to push.
     */
    public static void pushContext(Context ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        CONTEXT_STACK.get().push(ctx);
    }

    /**
     * Pops the current context off the thread-local stack. 
     * If the stack is empty, this operation should ideally handle it gracefully 
     * (though Python's pop() would throw an IndexError).
     */
    public static void popContext() {
        Stack<Context> stack = CONTEXT_STACK.get();
        if (stack != null && !stack.isEmpty()) {
            stack.pop();
        } else {
             // Optionally log or handle the case where popping an empty stack is called
        }
    }

    /**
     * Determines the default color value, prioritizing an explicit color 
     * argument over the context's stored color.
     * 
     * @param color An optional boolean representing the desired color (can be null).
     * @return The resolved color, or null if no color is determined.
     */
    public static Boolean resolveColorDefault(Boolean color) {
        // If an explicit color is provided, use it immediately.
        if (color != null) {
            return color;
        }

        // Get the current context silently.
        Optional<Context> optionalCtx = getCurrentContext();

        if (optionalCtx.isPresent()) {
            return optionalCtx.get().getColor();
        }

        return null;
    }
}

/**
 * Placeholder class representing the execution context, 
 * required for compilation and method usage.
 */
class Context {
    private final Boolean color; // Using Boolean wrapper to allow null/Optional behavior

    public Context(Boolean color) {
        this.color = color;
    }

    public Boolean getColor() {
        return color;
    }
}