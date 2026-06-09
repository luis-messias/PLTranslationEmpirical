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

            if (i == 0) {
                // i = 0 case
                if (punctuation.indexOf(charStr) == -1) {
                    // Not punctuation
                    res.add(charStr);
                }
                // If punctuation, we skip (continue)
            } else {
                // i > 0 case
                
                // Since s[i] is always a single character string, we execute the 'else' logic path
                if (punctuation.indexOf(charStr) != -1) {
                    // Punctuation found
                    
                    // if res[-1] == '': res.pop()
                    if (!res.isEmpty() && res.get(res.size() - 1).equals("")) {
                        res.remove(res.size() - 1);
                    }
                    
                    // res.append(s[i])
                    res.add(charStr);
                    
                    // res.append('')
                    res.add("");
                } else {
                    // Not punctuation
                    res.add(charStr);
                }
            }
        }

        System.out.println(String.join("", res));
    }
}
