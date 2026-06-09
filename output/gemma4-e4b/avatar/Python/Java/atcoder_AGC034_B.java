import java.util.Scanner;

public class atcoder_AGC034_B {

    // Translating the unused gcd function
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String s = scanner.nextLine();
        scanner.close();

        StringBuilder t = new StringBuilder();
        int i = 0;
        int n = s.length();

        // Phase 1: Building string t
        while (i < n) {
            char currentChar = s.charAt(i);

            if (currentChar == 'A') {
                t.append('A');
                i += 1;
            } else if (currentChar == 'B') {
                if (i < n - 1) {
                    char nextChar = s.charAt(i + 1);
                    if (nextChar == 'C') {
                        t.append('D');
                        i += 2;
                    } else {
                        t.append('X');
                        i += 1;
                    }
                } else {
                    // Last character is 'B'
                    t.append('X');
                    i += 1;
                }
            } else {
                // Any other character
                t.append('X');
                i += 1;
            }
        }

        String resultT = t.toString();

        // Phase 2: Calculating total
        int total = 0;
        int numA = 0;
        for (int j = 0; j < resultT.length(); j++) {
            char currentChar = resultT.charAt(j);
            if (currentChar == 'X') {
                numA = 0;
            } else {
                if (currentChar == 'A') {
                    numA++;
                } else if (currentChar == 'D') {
                    // Assuming 'D' is the only character that triggers the count update
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