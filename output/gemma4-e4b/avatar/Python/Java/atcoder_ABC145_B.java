import java.util.Scanner;

public class atcoder_ABC145_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        int n = scanner.nextInt();
        
        // Read S
        String s = scanner.next();
        
        if (n % 2 != 0) {
            System.out.println("No");
        } else {
            int mid = n / 2;
            
            // Check if the first half equals the second half
            // s.substring(0, mid) is the first half (length mid)
            // s.substring(mid) is the second half (starting at mid)
            
            // Note: We assume s has at least length n, as implied by the Python logic.
            if (s.substring(0, mid).equals(s.substring(mid))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
        scanner.close();
    }
}