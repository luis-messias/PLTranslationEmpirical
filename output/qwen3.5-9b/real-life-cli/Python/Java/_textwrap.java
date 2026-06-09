import java.util.ArrayList;
import java.util.List;

public class TextWrapper {
    private int width = 79;
    private boolean breakLongWords = true;
    private String initialIndent = "";
    private String subsequentIndent = " ";
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setBreakLongWords(boolean breakLongWords) {
        this.breakLongWords = breakLongWords;
    }
    
    public TextWrapper extraIndent(String indent) throws Exception {
        String oldInitialIndent = initialIndent;
        String oldSubsequentIndent = subsequentIndent;
        
        try {
            initialIndent += indent;
            subsequentIndent += indent;
            
            yield(); // Simulates context manager behavior
            
        } finally {
            initialIndent = oldInitialIndent;
            subsequentIndent = oldSubsequentIndent;
        }
        
        return this;
    }
    
    private void handleLongWord(List<String> reversedChunks, List<String> curLine, 
                                int curLen, String last) throws Exception {
        if (breakLongWords && !curLine.isEmpty()) {
            // Handle long word breaking logic similar to Python's _handle_long_word
            return;
        } else if (!reversedChunks.isEmpty() && reversedChunks.get(reversedChunks.size() - 1).equals(last)) {
            curLine.add(last);
            reversedChunks.remove(reversedChunks.size() - 1);
        }
    }
    
    public String indentOnly(String text) throws Exception {
        List<String> lines = new ArrayList<>();
        
        for (String line : text.split("\n")) {
            if (!line.isEmpty()) {
                int idx = lines.size(); // Track current line index
                
                String indent;
                if (idx == 0 || !lines.isEmpty() && lines.get(lines.size() - 1).isEmpty()) {
                    indent = initialIndent;
                } else {
                    indent = subsequentIndent;
                }
                
                lines.add(indent + line);
            }
        }
        
        return String.join("\n", lines);
    }
    
    public static void main(String[] args) throws Exception {
        TextWrapper wrapper = new TextWrapper();
        System.out.println(wrapper.indentOnly("Hello\nWorld"));
    }
}