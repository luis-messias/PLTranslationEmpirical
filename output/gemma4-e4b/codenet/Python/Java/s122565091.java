import java.util.Scanner;

public class s122565091 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a and v (Line 1)
        int a = scanner.nextInt();
        int v = scanner.nextInt();

        // Read b and w (Line 2)
        int b = scanner.nextInt();
        int w = scanner.nextInt();

        // Read t (Line 3)
        int t = scanner.nextInt();

        if (a == b) {
            System.out.println("YES");
        } else if (v <= w) {
            System.out.println("NO");
        } else {
            // Calculate abs(a - b) / (v - w). Must use double for floating point division.
            double numerator = Math.abs(a - b);
            double denominator = v - w;
            
            double ratio = numerator / denominator;

            if (t < ratio) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        
        scanner.close();
    }
}