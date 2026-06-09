import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class atcoder_AGC003_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read N subsequent inputs to construct A
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                int X_i = scanner.nextInt();
                // A_i = X_i * N + i
                A.add(X_i * N + i);
            } else {
                // Handle case where input might be incomplete
                break;
            }
        }
        
        // A.sort()
        Collections.sort(A);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            // d = (A[i] % N) % 2
            int d = (A.get(i) % N) % 2;
            
            // if d % 2 != i % 2 :
            if (d % 2 != i % 2) {
                cnt += 1;
            }
        }

        // print ( cnt // 2 )
        System.out.println(cnt / 2);
        
        scanner.close();
    }
}