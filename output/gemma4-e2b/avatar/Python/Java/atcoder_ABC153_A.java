import java.util.Scanner;

public class atcoder_ABC153_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read h and a from the input line
        if (scanner.hasNextInt()) {
            int h = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                
                // sho = h / a (integer division)
                int sho = h / a;
                
                // am = h % a
                int am = h % a;
                
                // If remainder is not zero, increment sho
                if (am != 0) {
                    sho += 1;
                }
                
                System.out.println(sho);
            }
        }
        
        scanner.close();
    }
}