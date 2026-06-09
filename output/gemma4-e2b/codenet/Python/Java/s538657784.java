import java.util.Scanner;
import java.lang.Math;

public class s538657784 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            
            // Calculate sqN = int(math.sqrt(N))
            int sqN = (int) Math.sqrt(N);
            
            // Loop for i in range(sqN)
            for (int i = 0; i < sqN; i++) {
                int divisor = sqN - i;
                
                // Check if N % (sqN-i) == 0
                if (N % divisor == 0) {
                    // print(int(N/(sqN-i)+sqN-i)-2)
                    // N / divisor + divisor - 2
                    int result = (N / divisor) + divisor - 2;
                    System.out.println(result);
                    break;
                }
            }
        }
        scanner.close();
    }
}