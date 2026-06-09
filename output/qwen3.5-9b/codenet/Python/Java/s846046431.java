import java.util.*;
import java.io.*;

public class s846046431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // Sort in descending order
        Arrays.sort(A, Collections.reverseOrder());
        
        long S = 0;
        for (int a : A) {
            S += a;
        }
        
        for (int i = 0; i < M; i++) {
            if ((double)A[i] / S - 1.0 / (4 * M) < 0) {
                System.out.println("No");
                return;
            }
        }
        
        System.out.println("Yes");
    }
}