import java.util.Scanner;

public class atcoder_ABC171_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        int N = scanner.nextInt();

        // Read array a
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        // Calculate total (XOR sum)
        int total = 0;
        for (int x : a) {
            total ^= x;
        }

        // Calculate and print the result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int result = a[i] ^ total;
            sb.append(result);
            if (i < N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}