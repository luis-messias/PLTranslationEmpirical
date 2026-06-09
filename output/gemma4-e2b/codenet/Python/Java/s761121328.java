import java.util.Scanner;

public class s761121328 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read array A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            A[i] = scanner.nextInt();
        }

        // Calculate s based on the Python logic: s = A[0] ^ A[1] ^ ... ^ A[N-1]
        // The Python code calculates s = A[0]^A[1] and then XORs subsequent elements.
        int s;
        if (N < 2) {
            // Handle cases where N is too small, although input constraints usually prevent this.
            // If N=1, the logic breaks, but we must follow the structure.
            if (N == 1) {
                s = A[0]; // If N=1, the loop range(2, 1) is empty, s remains uninitialized by the first line.
            } else {
                s = 0;
            }
        } else {
            s = A[0] ^ A[1];
            for (int i = 2; i < N; i++) {
                s = s ^ A[i];
            }
        }


        // Calculate B
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = s ^ A[i];
        }

        // Output B as space-separated string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(B[i]);
            if (i < N - 1) {
                result.append(" ");
            }
        }
        System.out.println(result.toString());
        
        scanner.close();
    }
}