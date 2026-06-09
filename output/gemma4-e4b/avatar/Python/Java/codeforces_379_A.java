import java.util.Scanner;

public class codeforces_379_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two space-separated integers
        if (!scanner.hasNextLong()) {
            // Handle case where input might be missing or malformed
            return;
        }
        
        long candeleIntere = scanner.nextLong();
        long b = scanner.nextLong();
        
        scanner.close();

        long s = 0;
        long restoSciolte = 0;

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