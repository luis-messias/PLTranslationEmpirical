import java.util.Scanner;

public class atcoder_ABC145_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        
        // Read s
        String s = scanner.next();
        
        if (n % 2 != 0) {
            System.out.println("No");
        } else {
            int mid = n / 2;
            String firstHalf = s.substring(0, mid);
            String secondHalf = s.substring(mid);
            
            if (firstHalf.equals(secondHalf)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}