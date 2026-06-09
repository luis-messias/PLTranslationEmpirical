import java.util.Scanner;

public class codeforces_544_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        // Calculate max_k = ceil(n^2 / 2)
        // Using integer arithmetic: (n*n + 1) / 2
        long nSquared = (long) n * n;
        long maxK = (nSquared + 1) / 2;
        
        if (k <= maxK) {
            System.out.println("YES");
            
            int x = 0;
            
            for (int i = 0; i < n; i++) {
                StringBuilder rowOutput = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    // Condition: i and j have same parity AND we haven't printed k 'L's yet
                    if ((i % 2 == j % 2) && (x < k)) {
                        rowOutput.append('L');
                        x++;
                    } else {
                        rowOutput.append('S');
                    }
                }
                System.out.println(rowOutput.toString());
            }
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}