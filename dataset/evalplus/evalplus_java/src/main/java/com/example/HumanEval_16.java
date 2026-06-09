import java.util.HashSet;
import java.util.Set;

public class HumanEval_16 {
    public int countDistinctCharacters(String string) {
        Set<Character> distinctChars = new HashSet<>();
        for (char c : string.toLowerCase().toCharArray()) {
            distinctChars.add(c);
        }
        return distinctChars.size();
    }
}
