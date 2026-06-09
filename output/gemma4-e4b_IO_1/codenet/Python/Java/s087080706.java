import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class s087080706 {

    /**
     * Finds the insertion point (lower bound) for x in the sorted array a.
     * This mimics the behavior of bisect_left.
     * Returns the index i such that all a[j] < x for j < i, and all a[j] >= x for j >= i.
     */
    private static int bisectLeft(int[] a, int x) {
        int low = 0;
        int high = a.length; // Search range is [low, high)
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else {
                // a[mid] >= x, so mid could be the answer, try searching left
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n, m, x (First line)
        if (!scanner.hasNextInt()) {
            return; // Handle empty input
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();

        // 2. Read array a (Second line/remaining input)
        // We assume the remaining input consists of space-separated integers for array 'a'.
        // Since we don't know the size, we read until the end of the line/input block.
        java.util.ArrayList<Integer> listA = new java.util.ArrayList<>();
        while (scanner.hasNextInt()) {
            listA.add(scanner.nextInt());
        }
        
        int[] a = new int[listA.size()];
        for (int i = 0; i < listA.size(); i++) {
            a[i] = listA.get(i);
        }

        // 3. Calculate i = bisect(a, x)
        int i = bisectLeft(a, x);

        // 4. Calculate min(len(a[:i]), len(a[i:]))
        // len(a[:i]) is i
        // len(a[i:]) is a.length - i
        int result = Math.min(i, a.length - i);

        System.out.println(result);
        
        scanner.close();
    }
}
