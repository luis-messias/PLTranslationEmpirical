import java.util.Scanner;
import java.util.Arrays;

public class s273727373 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        int N = scanner.nextInt();
        
        // Read A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // B = list(A)
        int[] B = Arrays.copyOf(A, N);
        
        // count = 1
        int count = 1;
        
        // for i in A:
        for (int i : A) {
            // B[i-1] = count
            // Note: This assumes 1 <= i <= N, so i-1 is a valid index.
            B[i - 1] = count;
            
            // count += 1
            count++;
        }
        
        // print(*B)
        for (int i = 0; i < N; i++) {
            System.out.print(B[i] + (i == N - 1 ? "" : " "));
        }
        System.out.println();
        
        scanner.close();
    }
}