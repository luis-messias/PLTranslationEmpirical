import java.util.Scanner;

public class atcoder_ABC164_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read S and W from standard input
        if (scanner.hasNextInt()) {
            int S = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int W = scanner.nextInt();
                
                // Logic: print "unsafe" if S <= W else print "safe"
                if (S <= W) {
                    System.out.println("unsafe");
                } else {
                    System.out.println("safe");
                }
            }
        }
        
        scanner.close();
    }
}