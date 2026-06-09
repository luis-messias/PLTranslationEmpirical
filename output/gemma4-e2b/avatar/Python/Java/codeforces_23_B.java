import java.util.Scanner;

public class codeforces_23_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            // Read a
            int a = scanner.nextInt();
            
            if (a < 2) {
                System.out.println(0);
            } else {
                System.out.println(a - 2);
            }
        }
        
        scanner.close();
    }
}