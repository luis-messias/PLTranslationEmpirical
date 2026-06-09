import java.util.Scanner;

public class codeforces_569_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read t, s, q. Using long to prevent potential integer overflow 
        // since s * q can grow very large.
        long t = scanner.nextLong();
        long s = scanner.nextLong();
        long q = scanner.nextLong();
        
        long ans = 0;
        
        while (s < t) {
            s *= q;
            ans++;
        }
        
        System.out.println(ans);
        
        scanner.close();
    }
}