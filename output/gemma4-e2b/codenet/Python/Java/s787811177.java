import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class s787811177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<List<Integer>> ls = new ArrayList<>();

        // Read n lines of input
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            // Read the line of space-separated integers
            for (int j = 0; j < scanner.next(); j++) {
                if (scanner.hasNextInt()) {
                    row.add(scanner.nextInt());
                }
            }
            ls.add(row);
        }

        // Sort ls based on the sum of elements in each list, in reverse order (descending)
        Collections.sort(ls, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                int sum1 = list1.stream().mapToInt(Integer::intValue).sum();
                int sum2 = list2.stream().mapToInt(Integer::intValue).sum();
                // Sort in reverse order (descending sum)
                return Integer.compare(sum2, sum1);
            }
        });

        // Calculate taka (sum of elements at index 0, 2, 4, ...)
        long taka = 0;
        for (int i = 0; i < ls.size(); i += 2) {
            if (i < ls.get(i).size()) {
                taka += ls.get(i).get(0);
            }
        }

        // Calculate aoki (sum of elements at index 1, 3, 5, ...)
        long aoki = 0;
        for (int i = 1; i < ls.size(); i += 2) {
            if (i < ls.get(i).size()) {
                aoki += ls.get(i).get(1);
            }
        }

        // Print the result
        System.out.println(taka - aoki);

        scanner.close();
    }
}