import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class atcoder_ABC143_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read all space-separated integers from standard input
        ArrayList<Integer> lList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lList.add(scanner.nextInt());
        }
        
        if (lList.isEmpty()) {
            System.out.println(0);
            return;
        }

        // Convert to array and sort it
        int n = lList.size();
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = lList.get(i);
        }
        Arrays.sort(l);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = l[i];
                int b = l[j];
                
                // Calculate right: bisect_left(l, a + b)
                // Find the index of the first element >= a + b
                int right = findBisectLeft(l, a + b);
                
                // Calculate left: bisect_right(l, max(a - b, b - a))
                int diff = Math.max(a - b, b - a);
                // Find the index of the first element > diff (which is equivalent to bisect_right(l, diff))
                int left = findBisectRight(l, diff);
                
                // tmp = max(0, right - left)
                long tmp = Math.max(0, right - left);
                
                // if left <= i < right: tmp -= 1
                if (left <= i && i < right) {
                    tmp--;
                }
                
                // if left <= j < right: tmp -= 1
                if (left <= j && j < right) {
                    tmp--;
                }
                
                ans += tmp;
            }
        }

        // print(ans // 3)
        System.out.println(ans / 3);
    }

    // Helper function equivalent to bisect_left (finds insertion point for value)
    // Finds the index of the first element >= value
    private static int findBisectLeft(int[] arr, int value) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Helper function equivalent to bisect_right (finds insertion point for value)
    // Finds the index of the first element > value
    private static int findBisectRight(int[] arr, int value) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}