import java.util.Scanner;

public class codeforces_302_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read the string for sa calculation
        String saString = scanner.next();
        int sa = 0;
        for (char c : saString.toCharArray()) {
            if (c == '-') {
                sa++;
            }
        }

        // Calculate sa = min(n - sa, sa)
        sa = Math.min(n - sa, sa);

        StringBuilder result = new StringBuilder();

        // Loop M times
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) break;
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // b -= a
            int diff = b - a;

            // Check the condition: (b % 2 != 0) AND (b <= sa * 2)
            // Note: In Java, b % 2 != 0 checks for oddness.
            // sa << 1 is equivalent to sa * 2.
            boolean isOdd = (diff % 2 != 0);
            boolean withinRange = (diff <= sa * 2);

            if (isOdd && withinRange) {
                result.append("1\n");
            } else {
                result.append("0\n");
            }
        }

        System.out.print(result.toString());
        scanner.close();
    }
}