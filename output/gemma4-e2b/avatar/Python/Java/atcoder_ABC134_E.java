import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC134_E {

    // Helper function equivalent to binary_search, adapted to work with List<List<Integer>>
    // It finds the insertion point based on the last element of the inner lists.
    public static int binarySearch(List<List<Integer>> ans, int key) {
        int bad = -1;
        int good = ans.size();

        while (good - bad > 1) {
            int mid = (bad + good) / 2;
            // Check the last element of the list at index mid
            if (ans.get(mid).get(ans.get(mid).size() - 1) < key) {
                good = mid;
            } else {
                bad = mid;
            }
        }
        return good;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) {
                break;
            }
            int A = scanner.nextInt();

            // Find insertion index using the custom binary search logic
            int idx = binarySearch(ans, A);

            if (idx == ans.size()) {
                // If idx == len(ans), append [A]
                List<Integer> newList = new ArrayList<>();
                newList.add(A);
                ans.add(newList);
            } else {
                // Otherwise, append A to ans[idx]
                ans.get(idx).add(A);
            }
        }

        // Print len(ans)
        System.out.println(ans.size());

        scanner.close();
    }
}