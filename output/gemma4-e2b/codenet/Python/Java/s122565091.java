import java.util.Scanner;
import java.lang.Math;

public class s122565091 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a, v
        int a = scanner.nextInt();
        int v = scanner.nextInt();

        // Read b, w
        int b = scanner.nextInt();
        int w = scanner.nextInt();

        // Read t
        int t = scanner.nextInt();

        if (a == b) {
            System.out.println("YES");
        } else if (v <= w) {
            System.out.println("NO");
        } else {
            // v > w
            // Calculate the threshold: abs(a - b) / (v - w)
            double threshold = Math.abs(a - b) / (v - w);
            
            if (t < threshold) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        
        scanner.close();
    }
}