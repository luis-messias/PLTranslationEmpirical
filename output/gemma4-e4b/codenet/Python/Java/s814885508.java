import java.util.Scanner;
import java.lang.Math;

public class s814885508 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read X, K, D from a single line of space-separated input
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        if (parts.length < 3) {
            return;
        }

        int X = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);
        int D = Integer.parseInt(parts[2]);
        
        // Calculate r = X // D (integer division)
        int r = X / D;
        
        // Check the first condition
        if (Math.abs(r) > K) {
            System.out.println(Math.abs(X) - K * D);
            return;
        }
        
        // Calculate a
        int a = X - r * D;
        
        // Check the second condition
        if ((K - r) % 2 == 0) {
            System.out.println(a);
        } else {
            System.out.println(Math.abs(D - a));
        }
    }
}