import java.util.Scanner;
import java.util.ArrayList;

public class s170274782 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[2][N];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                count += A[0][j];
            }
            for (int j = i; j < N; j++) {
                count += A[1][j];
            }
            ans.add(count);
        }
        
        int max = 0;
        for (int val : ans) {
            if (val > max) {
                max = val;
            }
        }
        
        System.out.println(max);
    }
}
