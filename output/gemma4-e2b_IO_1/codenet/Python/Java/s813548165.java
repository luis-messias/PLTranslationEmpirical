import java.util.Scanner;

public class s813548165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (first line)
        if (!scanner.hasNextInt()) {
            return;
        }
        // N is read but not used in the core logic, we consume it.
        int N = scanner.nextInt();
        
        // Read the line containing S and T
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        if (parts.length < 2) {
            return;
        }
        
        String S = parts[0];
        String T = parts[1];

        StringBuilder result = new StringBuilder();

        // Iterate through S and interleave characters from T
        for (int i = 0; i < S.length(); i++) {
            // Append character from S
            result.append(S.charAt(i));
            
            // Append corresponding character from T if it exists
            if (i < T.length()) {
                result.append(T.charAt(i));
            }
        }

        System.out.println(result.toString());
    }
}
