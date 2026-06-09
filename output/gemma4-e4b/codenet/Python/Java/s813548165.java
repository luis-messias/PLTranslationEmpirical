import java.util.Scanner;

public class s813548165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (must consume this input even if unused)
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume the rest of the line
        }

        // Read S and T
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        if (parts.length < 2) {
            // Handle insufficient input
            return;
        }
        
        String S = parts[0];
        String T = parts[1];
        
        StringBuilder result = new StringBuilder();
        int length = Math.min(S.length(), T.length());
        
        for (int i = 0; i < length; i++) {
            // Append S[i]
            result.append(S.charAt(i));
            // Append T[i]
            result.append(T.charAt(i));
        }
        
        System.out.println(result.toString());
        
        scanner.close();
    }
}