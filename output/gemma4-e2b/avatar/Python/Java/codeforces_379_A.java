import java.util.Scanner;

public class codeforces_379_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read candeleIntere and b from a single line of input
        if (scanner.hasNextInt()) {
            int candeleIntere = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();
                
                int s = 0;
                int restoSciolte = 0;
                
                while (candeleIntere > 0 || restoSciolte >= b) {
                    // candeleIntere += restoSciolte // b
                    candeleIntere += restoSciolte / b;
                    
                    // restoSciolte %= b
                    restoSciolte %= b;
                    
                    // s += candeleIntere
                    s += candeleIntere;
                    
                    // restoSciolte += candeleIntere % b
                    restoSciolte += candeleIntere % b;
                    
                    // candeleIntere //= b
                    candeleIntere /= b;
                }
                
                System.out.println(s);
            }
        }
        
        scanner.close();
    }
}