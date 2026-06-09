import java.util.Scanner;

public class s764356857 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A and B
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        int min = B * 10;
        int max = (B + 1) * 10 - 1;
        
        int ans = -1;
        
        for (int i = min; i <= max; i++) {
            // Calculate int(i * 0.08). Casting to int truncates the decimal part.
            int calculatedA = (int)(i * 0.08);
            
            if (calculatedA == A) {
                ans = i;
                break;
            }
        }
        
        System.out.println(ans);
        
        scanner.close();
    }
}