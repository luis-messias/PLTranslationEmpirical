import java.util.Scanner;

public class atcoder_AGC034_B {

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String s = scanner.nextLine();
        
        StringBuilder t = new StringBuilder();
        int i = 0;
        
        // Transformation logic
        while (i < s.length()) {
            char current = s.charAt(i);
            if (current == 'A') {
                t.append('A');
                i += 1;
            } else if (current == 'B') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    t.append('D');
                    i += 2;
                } else {
                    t.append('X');
                    i += 1;
                }
            } else {
                t.append('X');
                i += 1;
            }
        }

        // Calculation logic
        long total = 0;
        long numA = 0;
        
        for (int j = 0; j < t.length(); j++) {
            char charT = t.charAt(j);
            if (charT == 'X') {
                numA = 0;
            } else {
                if (charT == 'A') {
                    numA += 1;
                } else {
                    // If it's not 'A' and not 'X', add current numA to total
                    total += numA;
                }
            }
        }
        
        System.out.println(total);
    }

    public static void main(String[] args) {
        solve();
    }
}