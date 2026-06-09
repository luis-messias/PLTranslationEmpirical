import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_268_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        // Read N
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after N

        // q stores the list of string arrays
        List<String[]> q = new ArrayList<>();
        
        // Read N lines into q
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            // Split by space. If the line is empty, split might return an array containing one empty string, 
            // or we handle it explicitly. Assuming standard space separation.
            String[] a = line.trim().isEmpty() ? new String[0] :