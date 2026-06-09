import java.util.Scanner;

public class s869207096 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        // Read s (the string)
        if (!scanner.hasNext()) return;
        String s = scanner.next();
        
        // The logic counts the number of contiguous blocks of identical characters.
        // Initialize count to 1 (assuming the string is non-empty, which is implied by the Python code structure)
        int cnt = 1;
        
        // Iterate through the string up to the second to last character
        for (int i = 0; i < s.length() - 1; i++) {
            // Check if the current character is different from the next one
            if (s.charAt(i) != s.charAt(i + 1)) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
        
        scanner.close();
    }
}