import java.util.Scanner;

public class codeforces_67_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k (assuming they are on the first line)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Read array M (assuming n elements follow)
        int[] M = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            M[i] = scanner.nextInt();
        }
        
        // m = 0 (unused variable in the original logic, can be ignored)

        StringBuilder result = new StringBuilder();

        for (int j = 0; j < n; j++) {
            int p = -1;
            
            // Find the first index p where M[p] == 0
            for (int current_p = 0; current_p < n; current_p++) {
                if (M[current_p] == 0) {
                    p = current_p;
                    break;
                }
            }

            // Output p + 1 if found
            if (p != -1) {
                result.append(p + 1).append(" ");
            }

            // Update M[l] for l in range(p + 1 - k)
            int limit = p + 1 - k;
            if (limit > 0) {
                for (int l = 0; l < limit; l++) {
                    M[l] -= 1;
                }
            }
            
            // Update M[p]
            if (p != -1) {
                M[p] -= 1;
            }
        }

        // Print the final result, trimming trailing space if necessary
        if (result.length() > 0) {
            System.out.println(result.toString().trim());
        }
        
        scanner.close();
    }
}
