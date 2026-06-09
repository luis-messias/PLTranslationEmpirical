import java.util.Scanner;

public class codeforces_445_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        // Read N and M
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Process N rows
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String s = scanner.next();
            char[] chars = s.toCharArray();

            for (int j = 0; j < m; j++) {
                if (chars[j] == '.') {
                    // Check parity of (i + j)
                    // (i + j) & 1 == 1 means odd -> 'W'
                    // (i + j) & 1 == 0 means even -> 'B'
                    if ((i + j) % 2 != 0) { // Odd
                        chars[j] = 'W';
                    } else { // Even
                        chars[j] = 'B';
                    }
                }
            }
            System.out.println(new String(chars));
        }
        
        scanner.close();
    }
}