import java.util.Scanner;

public class codeforces_23_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            // Read a
            if (!scanner.hasNextInt()) {
                break;
            }
            int a = scanner.nextInt();
            
            // Python logic:
            // if a < 2: print(0)
            if (a < 2) {
                System.out.println(0);
            }
            
            // if a >= 2: print(a - 2)
            if (a >= 2) {
                System.out.println(a - 2);
            }
        }
        
        scanner.close();
    }
}