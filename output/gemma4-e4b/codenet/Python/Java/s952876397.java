import java.util.Scanner;

public class s952876397 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        // Read s
        String s = scanner.nextLine();
        
        // 1. Calculate 'left' (count of leading ')')
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                left++;
            } else {
                break;
            }
        }
        
        // 2. Calculate 'left1' and 'right1'
        int left1 = 0;
        int right1 = 0;
        
        // Iterate from index 'left' up to n-1
        for (int i = left; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                right1++;
            } else if (c == ')') {
                if (right1 > 0) {
                    right1--;
                } else {
                    left1++;
                }
            }
        }
        
        // 3. Update left1
        left1 += left;
        
        // 4. Modify s using StringBuilder
        StringBuilder sb = new StringBuilder(s);
        
        // Append right1 number of ')'
        for (int i = 0; i < right1; i++) {
            sb.append(")");
        }
        
        // Prepend left1 number of '('
        for (int i = 0; i < left1; i++) {
            sb.insert(0, "(");
        }
        
        // Output the result
        System.out.println(sb.toString());
    }
}