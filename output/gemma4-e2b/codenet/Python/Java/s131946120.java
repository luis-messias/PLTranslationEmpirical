import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s131946120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read n lines and store them in a set to find unique elements
        Set<String> uniqueInputs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                uniqueInputs.add(scanner.nextLine());
            }
        }

        // Print the size of the set
        System.out.println(uniqueInputs.size());

        scanner.close();
    }
}