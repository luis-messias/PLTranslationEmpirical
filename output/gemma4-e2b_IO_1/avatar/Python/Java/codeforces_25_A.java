import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_25_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first input)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        // Read the line for the list
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Process the list: [int(x) % 2 for x in input().split()]
        List<Integer> list = new ArrayList<>();
        String[] tokens = line.trim().split("\\s+");
        
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int x = Integer.parseInt(token);
                    list.add(x % 2);
                } catch (NumberFormatException e) {
                    // Ignore invalid tokens
                }
            }
        }

        // Calculate sum
        int sum = 0;
        for (int val : list) {
            sum += val;
        }

        // Conditional logic
        if (sum == 1) {
            // print(list.index(1) + 1)
            int index = list.indexOf(1);
            if (index != -1) {
                System.out.println(index + 1);
            }
        } else {
            // print(list.index(0) + 1)
            int index = list.indexOf(0);
            if (index != -1) {
                System.out.println(index + 1);
            }
        }
    }
}
