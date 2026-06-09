import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC109_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int n = scanner.nextInt();
        
        String[] l = new String[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNext()) {
                l[i] = scanner.next();
            } else {
                // Handle case where input ends prematurely
                return;
            }
        }
        
        Map<String, Integer> s = new HashMap<>();
        String f = "Yes";
        
        for (int i = 0; i < n; i++) {
            String v = l[i];
            
            // 1. Update count
            s.put(v, s.getOrDefault(v, 0) + 1);
            
            // 2. Check for duplicates
            if (s.get(v) >= 2) {
                f = "No";
            }
            
            // 3. Check continuity (only if i > 0)
            if (i > 0) {
                String previous = l[i - 1];
                
                // Check if the last character of the previous string matches the first character of the current string
                char lastCharPrevious = previous.charAt(previous.length() - 1);
                char firstCharCurrent = v.charAt(0);
                
                if (lastCharPrevious != firstCharCurrent) {
                    f = "No";
                }
            }
        }
        
        System.out.println(f);
        
        scanner.close();
    }
}
