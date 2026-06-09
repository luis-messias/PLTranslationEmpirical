import java.util.Scanner;

public class s043174379 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read H and W (assuming they are on the first line)
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        
        // Read h and w (assuming they are on the second line)
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        
        // Calculate ans = H * W - (h * W + w * H - h * w)
        int ans = H * W - (h * W + w * H - h * w);
        
        System.out.println(ans);
        
        scanner.close();
    }
}