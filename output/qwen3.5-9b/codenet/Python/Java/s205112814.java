import java.util.Scanner;

public class s205112814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int maxUnderTh = Integer.MIN_VALUE;
        int minUpperTh = Integer.MAX_VALUE;
        
        for (int i = 0; i < m; i++) {
            int lower = scanner.nextInt();
            int upper = scanner.nextInt();
            
            if (lower > maxUnderTh) {
                maxUnderTh = lower;
            }
            
            if (upper < minUpperTh) {
                minUpperTh = upper;
            }
        }
        
        if (minUpperTh - maxUnderTh >= 0) {
            System.out.println(minUpperTh - maxUnderTh + 1);
        } else {
            System.out.println(0);
        }
        
        scanner.close();
    }
}