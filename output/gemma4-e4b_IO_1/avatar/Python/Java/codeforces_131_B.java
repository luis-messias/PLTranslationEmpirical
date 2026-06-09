import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_131_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (required to consume the first line)
        if (!scanner.hasNextInt()) {
            System.out.println(0);
            return;
        }
        int n = scanner.nextInt();

        // Map to store counts: value -> count
        Map<Integer, Long> counts = new HashMap<>();
        
        // Read all remaining tokens as integers
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            counts.put(num, counts.getOrDefault(num, 0L) + 1);
        }
        
        scanner.
