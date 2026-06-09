import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class s787811177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        List<List<Integer>> ls = new ArrayList<>();

        // Read n lines of input
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse space-separated integers into a list
                List<Integer> row = Arrays.stream(line.split(" "))
                                        .filter(s -> !s.isEmpty())
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
                ls.add(row);
            }
        }

        // Sort ls based on the sum of elements in each list, in reverse order (descending)
        ls.sort((list1, list2) -> {
            // Calculate sums using long to be safe, although the elements are ints
            long sum1 = list1.stream().mapToLong(Integer::intValue).sum();
            long sum2 = list2.stream().mapToLong(Integer::intValue).sum();
            // Sort in reverse order (descending sum)
            return Long.compare(sum2, sum1);
        });

        // Calculate taka (sum of elements at index 0,
