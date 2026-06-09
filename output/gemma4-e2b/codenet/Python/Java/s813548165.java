import java.util.Scanner;

public class s813548165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (although N is not strictly used in the logic, we read it to consume the input line)
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        
        // Read S and T from the next line
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

        for (int i = 0; i < S.length(); i++) {
            result.append(S.charAt(i));
            // Assuming T has at least S.length() characters based on the Python indexing T[i]
            if (i < T.length()) {
                result.append(T.charAt(i));
            }
        }

        System.out.println(result.toString());
    }
}