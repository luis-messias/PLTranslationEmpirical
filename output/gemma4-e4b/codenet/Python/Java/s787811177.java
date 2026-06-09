import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class s787811177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        // Read data into a list of int arrays
        ArrayList<int[]> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int a = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int b = scanner.nextInt();
            ls.add(new int[]{a, b});
        }
        
        scanner.close();

        // Sort ls based on the sum of elements (a+b) in descending order.
        // Comparator: (arr1, arr2) -> (sum2 - sum1) for descending order.
        Collections.sort(ls, (arr1, arr2) -> {
            int sum1 = arr1[0] + arr1[1];
            int sum2 = arr2[0] + arr2[1];
            return Integer.compare(sum2, sum1);
        });

        long taka = 0;
        long aoki = 0;

        // Calculate taka and aoki
        for (int i = 0; i < ls.size(); i++) {
            int[] current = ls.get(i);
            if (i % 2 == 0) {
                // Even index: contributes to taka (first element)
                taka += current[0];
            } else {
                // Odd index: contributes to aoki (second element)
                aoki += current[1];
            }
        }

        // Print the result
        System.out.println(taka - aoki);
    }
}