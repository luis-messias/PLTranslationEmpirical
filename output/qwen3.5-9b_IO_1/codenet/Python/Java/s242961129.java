import java.util.Scanner;

public class s242961129 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        int ans = Math.abs(A[N - 1]);
        int[] extendedA = new int[N + 2];
        extendedA[0] = 0;
        for (int i = 0; i < N; i++) {
            extendedA[i + 1] = A[i];
        }
        extendedA[N + 1] = 0;
        
        int[] diff = new int[N];
        for (int i = 1; i <= N; i++) {
            int dif = Math.abs(extendedA[i] - extendedA[i - 1]) + 
                      Math.abs(extendedA[i] - extendedA[i + 1]) - 
                      Math.abs(extendedA[i - 1] - extendedA[i + 1]);
            ans += Math.abs(extendedA[i] - extendedA[i - 1]);
            diff[i - 1] = dif;
        }
        
        for (int i = 0; i < N; i++) {
            System.out.println(ans - diff[i]);
        }
    }
}
