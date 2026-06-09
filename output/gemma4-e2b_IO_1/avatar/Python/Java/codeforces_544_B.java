import java.util.Scanner;

public class codeforces_544_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int k = scanner.nextInt();

                // Calculate the maximum value for the condition: max(n^2 // 2, n^2 - (n^2 // 2))
                long nSquared = (long) n * n;
                long nSquaredDiv2 = nSquared / 2;
                long maxVal = Math.max(nSquaredDiv2, nSquared - nSquaredDiv2);

                if (k <= maxVal) {
                    System.out.println("YES");
                    
                    int x = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i % 2 == j % 2) {
                                // Original logic: if i % 2 == j % 2 and x < k: print 'L', x += 1, else print 'S'
                                if (x < k) {
                                    System.out.print("L");
                                    x++;
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
                    System.out.println("NO");
                }
            }
        }
        scanner.close();
    }
}
