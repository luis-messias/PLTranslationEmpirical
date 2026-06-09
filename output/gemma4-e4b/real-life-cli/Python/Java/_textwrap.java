import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Mimics the functionality of Python's textwrap.TextWrapper, adding custom
 * long word handling and indentation context management.
 */
public class TextWrapper {
    private String initialIndent = "";
    private String subsequentIndent = "";
    private boolean breakLongWords = true; // Assuming default behavior

    // Constructor (optional, but good practice)
    public TextWrapper() {}

    /**
     * Handles the logic for breaking long words when wrapping text.
     * This method assumes it is called within a larger text wrapping context.
     *
     * @param reversedChunks List of word chunks remaining to be processed (reversed order).
     * @param curLine The list representing the current line being built.
     * @param curLen The current length of the content on the line.
     * @param width The maximum allowed width.
     */
    public void handleLongWord(
            List<String> reversedChunks,
            List<String> curLine,
            int curLen,
            int width) {
        int spaceLeft = Math.max(width - curLen, 1);

        if (this.breakLongWords) {
            String last = reversedChunks.get(reversedChunks.size() - 1);
            // Calculate cut and remainder
            String cut = last.substring(0, Math.min(last.length(), spaceLeft));
            String res = last.substring(Math.min(last.length(), spaceLeft));

            curLine.add(cut);
            // Update the list element in place (mimicking Python's assignment)
            reversedChunks.set(reversedChunks.size() - 1, res);
        } else if (curLine.isEmpty()) {
            // Pop the last element and use it
            String word = reversedChunks.remove(reversedChunks.size() - 1);
            curLine.add(word);
        }
    }

    /**
     * Executes a block of code while temporarily modifying indentation levels.
     * This mimics Python's context manager behavior using Java's functional interface pattern.
     *
     * @param indent The string to prepend as the new indentation.
     * @param action The consumer that executes the logic within the modified scope.
     */
    public void extraIndent(String indent, Consumer<Void> action) {
        // Store original state
        String oldInitialIndent = this.initialIndent;
        String oldSubsequentIndent = this.subsequentIndent;

        // Apply new state
        this.initialIndent += indent;
        this.subsequentIndent += indent;

        try {
            action.accept(null); // Execute the action block
        } finally {
            // Restore original state (cleanup)
            this.initialIndent = oldInitialIndent;
            this.subsequentIndent = oldSubsequentIndent;
        }
    }

    /**
     * Indents every line of the given text based on current initial and subsequent indent settings.
     *
     * @param text The input string to be indented.
     * @return The fully indented string.
     */
    public String indentOnly(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] lines = text.split("\\r?\\n"); // Handle both \r\n and \n

        for (int idx = 0; idx < lines.length; idx++) {
            String indent = (idx == 0) ? this.initialIndent : this.subsequentIndent;
            sb.append(indent).append(lines[idx]);
            if (idx < lines.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    // --- Example Usage/Getters for testing purposes ---
    public String getInitialIndent() { return initialIndent; }
    public void setInitialIndent(String initialIndent) { this.initialIndent = initialIndent; }
    public String getSubsequentIndent() { return subsequentIndent; }
    public void setSubsequentIndent(String subsequentIndent) { this.subsequentIndent = subsequentIndent; }
}