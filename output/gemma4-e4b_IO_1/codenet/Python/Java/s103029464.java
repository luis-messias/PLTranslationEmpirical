import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s103029464 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] B = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            int tmp_sum = 0;
            
            // Inner loop: j starts at (i + 1) * 2 - 1, steps by (i + 1)
            int start_j = (i + 1) * 2 - 1;
            int step = i + 1;
            
            for (int j = start_j; j < N; j += step) {
                // Calculate parity (XOR sum)
                tmp_sum ^= B[j]; 
            }
            
            // B[i] = tmp_sum ^ A[i]
            B[i] = tmp_sum ^ A[i];
        }

        // Print sum(B)
        long sumB = 0;
        for (int b : B) {
            sumB += b;
        }
        System.out.println(sumB);

        // Print 1-based indices where B[i] == 1
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (B[i] == 1) {
                indices.add(i + 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.size(); i++) {
            sb.append(indices.get(i));
            if (i < indices.size() - 1) {
                sb.
