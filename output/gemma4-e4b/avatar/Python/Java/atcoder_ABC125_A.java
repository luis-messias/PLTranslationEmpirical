import java.util.Scanner;

public class atcoder_ABC125_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read a, b, t from standard input
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int t_int = scanner.nextInt();
        
        scanner.close();
        
        int cookie = 0;
        // time must be a double to correctly handle the t + 0.5 comparison
        double time = (double) a;
        
        // Calculate the loop limit: t + 0.5
        double limit = t_int + 0.5;
        
        while (time <= limit) {
            cookie += b;
            time += a;
        }
        
        System.out.println(cookie);
    }
}