import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class codeforces_609_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m (assuming they are on the first line)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Read the list lst (assuming it's on the second line)
        List<Integer> lstList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                lstList.add(scanner.nextInt());
            } else {
                // Handle case where input might be shorter than expected
                break;
            }
        }

        // Convert List to array for easier indexing if needed, or use List directly
        int[] lst = lstList.stream().mapToInt(i -> i).toArray();

        // Step 1: Calculate frequencies (l)
        Map<Integer, Integer> l = new HashMap<>();
        for (int x : lst) {
            l.put(x, l.getOrDefault(x, 0) + 1);
        }

        // Step 2: Calculate result (res)
        long res =