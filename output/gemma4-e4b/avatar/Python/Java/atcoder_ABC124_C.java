import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC124_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        int N = s.length();

        // Counters for characters at even indices (0, 2, 4, ...)
        int even0 = 0;
        int even1 = 0;
        // Counters for characters at odd indices (1, 3, 5, ...)
        int odd0 = 0;
        int odd1 = 0;

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            boolean isEvenIndex = (i % 2 == 0);

            if (isEvenIndex) {
                if (c == '0') {
                    even0++;
                } else {
                    even1++;
                }
            } else { // Odd index
                if (c == '0') {
                    odd0++;
                } else {
                    odd1++;
                }
            }
        }

        // Calculate V1 = N - (even['0'] + odd['1'])
        int v1 = N - (even0 + odd1);

        // Calculate V2 = N - (even['1'] + odd['0'])
        int v2 = N - (even1 + odd0);

        // Print min(V1, V2)
        System.out.println(Math.min(v1, v2));
    }
}