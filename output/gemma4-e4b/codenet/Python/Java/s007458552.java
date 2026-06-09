import java.util.Scanner;

public class s007458552 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading n
        scanner.nextLine(); 
        
        // Read S
        String S = scanner.nextLine();
        
        // Count 'R'
        int countR = 0;
        for (char c : S.toCharArray()) {
            if (c == 'R') {
                countR++;
            }
        }
        
        // Check condition: countR > n - countR  <=> 2 * countR > n
        if (2 * countR > n) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}