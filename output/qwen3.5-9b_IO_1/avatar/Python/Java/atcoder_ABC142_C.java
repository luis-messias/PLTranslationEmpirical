import java.util.*;

public class atcoder_ABC142_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = i + 1;
            A[i][1] = sc.nextInt();
        }
        
        Arrays.sort(A, (a, b) -> Integer.compare(a[1], b[1]));
        
        for (int i = 0; i < N - 1; i++) {
            System.out.print(A[i][0] + " ");
        }
        System.out.println(A[N - 1][0]);
    }
}
