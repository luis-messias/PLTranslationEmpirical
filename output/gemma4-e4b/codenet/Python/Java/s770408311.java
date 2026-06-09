import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s770408311 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading N
        scanner.nextLine(); 
        
        Set<String> uniqueInputs = new HashSet<>();
        
        // Read N lines of strings
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String a = scanner.nextLine();
                uniqueInputs.add(a);
            } else {
                break;
            }
        }
        
        System.out.println(uniqueInputs.size());
        
        scanner.close();
    }
}