import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class atcoder_ABC105_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextLong()) {
            return;
        }
        long N = scanner.nextLong();
        long M = scanner.nextLong();

        // Read array A
        long[] A = new long[(int) N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        
        // Calculate cumulative remainders (Size N+1)
        // cumRemainders[i] stores (A[0]
