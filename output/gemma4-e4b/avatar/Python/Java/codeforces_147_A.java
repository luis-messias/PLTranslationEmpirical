import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_147_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        List<String> res = new ArrayList<>();
        String punctuation = ",.!?";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String charStr = String.valueOf(c);

            if (i >= 1) {
                // Python check: if s[i] == ''
                // In Java, charStr will never be empty, so this block is effectively skipped.
                // We proceed to the 'else' block which handles non-empty characters.
                
                // Since charStr is always non-empty, we execute the 'else' logic path.
                if (punctuation.indexOf(charStr) != -1) {
                    // Punctuation found
                    if (!res.isEmpty() && res.get(res.size() - 1).equals("")) {
                        res.remove(res.size() - 1);
                    }
                    res.add(charStr);
                    res.add("");
                } else {
                    // Not punctuation
                    res.add(charStr);
                }
            } else {
                // i == 0 case
                // Python check: if s[i] == '' (Always false)
                
                if (punctuation.indexOf(charStr) == -1) {
                    // Not punctuation
                    res.add(charStr);
                }
                // If it is punctuation, we skip (continue)