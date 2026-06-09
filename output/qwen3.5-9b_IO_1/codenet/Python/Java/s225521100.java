import java.util.Scanner;

public class s225521100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] A = new int[N];
        
        for (int i = 0; i < K; i++) {
            int d = sc.nextInt();
            for (int j = 0; j < d; j++) {
                int val = sc.nextInt();
                A[val - 1] = 1;
            }
        }
        
        int n = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                n++;
            }
        }
        
        System.out.println(n);
    }
}
