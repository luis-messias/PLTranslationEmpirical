import java.util.Scanner;

public class s103354654 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read W, H, x, y, r from standard input
        if (!scanner.hasNextInt()) {
            // Handle case where no input is provided, though usually unnecessary for competitive programming style translation
            return;
        }
        
        int W = scanner.nextInt();
        int H = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int r = scanner.nextInt();
        
        scanner.close();

        if (x >= r && (W - r) >= x) {
            if (y >= r && (H - r) >= y) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
    }
}