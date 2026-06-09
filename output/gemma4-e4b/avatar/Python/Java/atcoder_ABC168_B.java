import java.util.Scanner;

public class atcoder_ABC168_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read K (integer)
        if (!scanner.hasNextInt()) {
            return;
        }
        int K = scanner.nextInt();
        
        // Consume the newline character left by nextInt()
        scanner.nextLine(); 
        
        // Read S (string)
        String S = scanner.nextLine();
        
        String result;
        
        if (S.length() <= K) {
            result = S;
        } else {
            // Get the first K characters
            result = S.substring(0, K) + "...";
        }
        
        System.out.println(result);
        
        scanner.close();
    }
}