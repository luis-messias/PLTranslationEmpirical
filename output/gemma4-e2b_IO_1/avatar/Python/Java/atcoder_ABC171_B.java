import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class atcoder_ABC171_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K from the first line
        if (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String[] parts = line1.split(" ");
            if (parts.length >= 2) {
                // N is parts[0], K is parts[1]
                // int n = Integer.parseInt(parts[0]); // N is not strictly needed for the calculation if we read the next line directly
                int k = Integer.parseInt(parts[1]);

                // Read the list of numbers from the second line
                if (scanner.hasNextLine()) {
                    String line2 = scanner.nextLine();
                    String[] parts2 = line2.split(" ");
                    
                    List<Integer> numbers = new java.util.ArrayList<>();
                    for (String part : parts2) {
                        if (!part.isEmpty()) {
                            numbers.add(Integer.parseInt(part));
                        }
                    }

                    // Calculate sum(sorted(list)[:k])
                    
                    // 1. Sort the list
                    Collections.sort(numbers);

                    // 2. Take the first K elements (or fewer if list size < K)
                    int count = Math.min(k, numbers.size());
                    
                    // 3. Sum these elements
                    long sum = 0;
                    for (int i = 0; i < count; i++) {
                        sum += numbers.get(i);
                    }

                    System.out.println(sum);
                }
            }
        }
        scanner.close();
    }
}
