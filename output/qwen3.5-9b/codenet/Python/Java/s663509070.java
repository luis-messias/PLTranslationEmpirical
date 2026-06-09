import java.util.Scanner;

public class s663509070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        
        int[][] mat = new int[N][D];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < D; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        
        int c = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double sumSq = 0;
                for (int k = 0; k < D; k++) {
                    sumSq += (mat[i][k] - mat[j][k]) * (mat[i][k] - mat[j][k]);
                }
                double dist = Math.sqrt(sumSq);
                if (dist == (int)dist) {
                    c++;
                }
            }
        }
        
        System.out.println(c);
    }
}