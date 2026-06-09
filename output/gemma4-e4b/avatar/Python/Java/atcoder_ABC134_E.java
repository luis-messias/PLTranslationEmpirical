import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC134_E {

    /**
     * Performs a binary search on the last element of the lists stored in 'ans'.
     * It finds the smallest index 'i' such that the last element of ans.get(i) >= key.
     * If no such index exists, it returns ans.size().
     *
     * @param key The target value.
     * @param ans The list of lists (the data structure being searched).
     * @return The calculated index.
     */
    private static int binarySearch(int key, List<List<Integer>> ans) {
        int bad = -1;
        int good = ans.size();

        while (good - bad > 1) {
            int mid = (bad + good) / 2;
            
            // Check the last element of the group at index mid
            // Since we only append or create groups, ans.get(mid) is guaranteed to be non-empty 
            // if mid < ans.size().
            int lastElement = ans.get(mid).get(ans.get(mid).size() - 1);

            if (lastElement < key) {
                // The target index must be in the range [bad, mid]
                good = mid;
            } else {
                // The target index must be in the range [mid, good]
                bad = mid;
            }
        }
        return good;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            // Handle case where N is not provided
            System.out.println(0);
            return;
        }
        int N = scanner.nextInt();

        // ans: List of Lists of Integers
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) {
                // Should not happen if N was read correctly, but good practice.
                break;
            }
            int A = scanner.nextInt();
            
            // Find the index where A should be placed
            int idx = binarySearch(A, ans);

            if (idx == ans.size()) {
                // New group needed
                List<Integer> newGroup = new ArrayList<>();
                newGroup.add(A);
                ans.add(newGroup);
            } else {
                // Append to existing group
                ans.get(idx).add(A);