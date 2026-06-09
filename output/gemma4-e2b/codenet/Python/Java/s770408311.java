import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s770408311 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Use a Set to store unique strings
        Set<String> uniqueStrings = new HashSet<>();

        // Read n strings
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                uniqueStrings.add(s);
            }
        }

        // Print the count of unique strings
        System.out.println(uniqueStrings.size());

        scanner.close();
    }
}