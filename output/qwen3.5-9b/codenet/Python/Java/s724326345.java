import java.util.Scanner;

public class s724326345 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long X = sc.nextLong();
        long Y = sc.nextLong();
        
        long ans = 10000000000L;
        
        for (long k = 0; k <= Math.max(X, Y); k++) {
            long total = 2 * C * k + A * Math.max(0, X - k) + B * Math.max(0, Y - k);
            if (total < ans) {
                ans = total;
            }
        }
        
        System.out.println(ans);
    }
}