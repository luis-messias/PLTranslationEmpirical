import java.util.Scanner;

public class s747093551 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
        }
        
        int[] y = new int[M];
        for (int i = 0; i < M; i++) {
            y[i] = sc.nextInt();
        }
        
        int maxX = X;
        for (int val : x) {
            maxX = Math.max(maxX, val);
        }
        
        int minY = Y;
        for (int val : y) {
            minY = Math.min(minY, val);
        }
        
        if (maxX < minY) {
            System.out.println("No War");
        } else {
            System.out.println("War");
        }
    }
}