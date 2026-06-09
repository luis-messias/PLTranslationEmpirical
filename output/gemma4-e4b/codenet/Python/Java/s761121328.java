import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class s761121328 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        int N = scanner.nextInt();

        // Read array A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // Calculate s (XOR sum of all elements in A)
        int s = 0;
        for (int x : A) {
            s ^= x;
        }

        // Calculate B
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = s ^ A[i];
        }

        // Format and print the result (space-separated string)
        String result = IntStream.of(B)
                                 .mapToObj(String::valueOf)
                                 .collect(Collectors.joining(" "));
        
        System.out.println(result);
        
        scanner.close();
    }
}