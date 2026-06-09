import java.util.Scanner;

public class codeforces_387_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read round_complexity (N elements)
        int[] roundComplexity = new int[n];
        for (int i = 0; i < n; i++) {
            roundComplexity[i] = scanner.nextInt();
        }

        // Read george_complexity (M elements)
        int[] georgeComplexity = new int[m];
        for (int i = 0; i < m; i++) {
            georgeComplexity[i] = scanner.nextInt();
        }

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            // Python logic: i += 1 * ( round_complexity[i] <= george_complexity[j] )
            if (roundComplexity[i] <= georgeComplexity[j]) {
                i++;
            }
            // j always increments
            j++;
        }

        System.out.println(n - i);
        
        scanner.close();
    }
}