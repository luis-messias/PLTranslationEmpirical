import java.util.Scanner;

public class s662673721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long ans = 1000000000000000000L; // 10^18
        
        for (int i = 1; i <= Math.sqrt(n) + 1; i++) {
            if (n % i != 0) {
                continue;
            }
            int j = n / i;
            ans = Math.min(ans, (long)i + j - 2);
        }
        
        System.out.println(ans);
    }
}
