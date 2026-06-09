import java.util.Scanner;

public class codeforces_544_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n and k
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int k = scanner.nextInt();

                // Calculate the maximum value for the condition
                // max(n^2 // 2, n^2 - (n^2 // 2))
                long nSquared = (long) n * n;
                long nSquaredDiv2 = nSquared / 2;
                long maxVal = Math.max(nSquaredDiv2, nSquared - nSquaredDiv2);

                if (k <= maxVal) {
                    System.out.print("YES");
                    
                    // The original Python code prints 'YES' once, then proceeds to print 'L'/'S' pairs.
                    // We need to replicate the exact output structure.
                    
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i % 2 == j % 2) {
                                if (k > 0) {
                                    System.out.print("L");
                                    k--;
                                } else {
                                    System.out.print("S");
                                }
                            } else {
                                System.out.print("S");
                            }
                        }
                        System.out.println();
                    }
                } else {
                    System.out.print("NO");
                }
            }
        }
        scanner.close();
    }
}