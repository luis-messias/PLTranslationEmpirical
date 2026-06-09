import java.util.Scanner;

public class s174910557 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N (ignored)
        if (scanner.hasNextInt()) {
            // Read N, although it is not used in the calculation
            scanner.nextInt();
            
            // Read S
            if (scanner.hasNext()) {
                String S = scanner.next();
                
                if (S == null || S.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                int ans = 1;
                char tmp = S.charAt(0);
                
                // Iterate over all characters in S
                for (int i = 1; i < S.length(); i++) {
                    char s = S.charAt(i);
                    if (s != tmp) {
                        ans++;
                        tmp = s;
                    }
                }
                
                System.out.println(ans);
            }
        }
        scanner.close();
    }
}
