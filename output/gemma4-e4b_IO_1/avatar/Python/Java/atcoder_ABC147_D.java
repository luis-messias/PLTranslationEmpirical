import java.util.Scanner;

public class atcoder_ABC147_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        
        // Read the N numbers into an array of long
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextLong()) {
                return;
            }
            A[i] = scanner.nextLong();
        }
        
        long result = 0;
        long MOD = 1000000007L;
        
        // Loop from b=0 to b=59
        for (int b =
