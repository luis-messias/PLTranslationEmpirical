import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_25_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n (and discard it, as it is unused in the logic)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading n
        scanner.nextLine(); 

        // 2. Read the list elements from the next line
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] tokens = line.trim().split("\\s+");

        List<Integer> list = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int num = Integer.parseInt(token);
                    list.add(num % 2);
                } catch (NumberFormatException e) {
                    // Skip invalid tokens
                }
            }
        }
        
        scanner.close();

        // 3. Calculate sum
        int sum = 0;
        for (int val : list) {
            sum += val;
        }

        int resultIndex = -1;
        
        if (sum == 1) {
            // Find index of 1 (first occurrence)
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 1) {
                    resultIndex = i + 1; // 1-based index
                    break;
                }
            }
        } else {
            // Find index of 0 (first occurrence)
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    resultIndex = i + 1; // 1-based index
                    break;
                }
            }
        }

        // 4. Print result
        if (resultIndex != -1) {
            System.out.println(resultIndex);
        }
    }
}
