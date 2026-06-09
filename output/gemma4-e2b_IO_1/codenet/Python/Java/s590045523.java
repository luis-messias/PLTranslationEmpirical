import java.util.Scanner;

public class s590045523 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read L
        int[] L = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            L[i] = scanner.nextInt();
        }

        long ans = 0;

        // Iterate through all unique triplets (i, j, k) such that i < j < k
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int a = L[i];
                    int b = L[j];
                    int c = L[k];

                    // Check if any two sides are equal
                    if (a == b || b == c || c == a) {
                        continue;
                    }

                    // Check triangle inequality: a+b>c and b+c>a and c+a>b
                    if (a + b > c && b + c > a && c + a > b) {
                        ans += 1;
                    }
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}
