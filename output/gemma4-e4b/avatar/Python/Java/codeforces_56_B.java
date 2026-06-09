import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class codeforces_56_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            System.out.println("0 0");
            return;
        }
        int N = scanner.nextInt();

        // Read array A
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                A.add(scanner.nextInt());
            } else {
                // Handle case where input might be incomplete
                System.out.println("0 0");
                return;
            }
        }
        scanner.close();

        // 1. Find mn and mx
        int mn = N + 1;
        int mx = -1;

        for (int i = 0; i < N; i++) {
            // Check if A[i] != i + 1
            if (A.get(i) != i + 1) {
                if (mn > i) {
                    mn = i;
                }
                if (mx < i) {
                    mx = i;
                }
            }
        }

        // 2. Output logic
        if (mx == -1) {
            System.out.println("0 0");
        } else {
            // 3. Reverse the segment A[mn] to A[mx]
            reverseSegment(A, mn, mx);

            // 4. Check if the modified array A is sorted
            if (isSorted(A)) {
                // Output mn+1 and mx+1
                System.out.println((mn + 1) + " " + (mx + 1));
            } else {
                System.out.println("0 0");
            }
        }
    }

    /**
     * Reverses the elements in the ArrayList A from index start to index end (inclusive).
     */
    private static void reverseSegment(ArrayList<Integer> A, int start, int end) {
        while (start < end) {
            // Swap A[start] and A[end]
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end, temp);
            
            start++;
            end--;
        }
    }

    /**
     * Checks if the ArrayList A is sorted in non-decreasing order.
     */
    private static boolean isSorted(ArrayList<Integer> A) {
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}