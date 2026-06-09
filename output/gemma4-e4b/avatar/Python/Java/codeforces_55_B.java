import java.util.Scanner;
import java.util.Arrays;

public class codeforces_55_B {

    /**
     * Recursive function to find the minimum number achievable after all operations.
     *
     * @param nums The array of numbers.
     * @param i The current operation index.
     * @param operations The array of operations ('+' or '*').
     * @param minAns A wrapper array holding the minimum answer found so far (passed by reference).
     */
    public static void rememberTheNumber(long[] nums, int i, String[] operations, long[] minAns) {
        if (i >= 3) {
            return;
        }

        // Iterate through all pairs (j, k) where j < k
        for (int j = 0; j < 4; j++) {
            for (int k = j + 1; k < 4; k++) {
                // Check if both numbers are available (not marked as -1)
                if (nums[j] != -1 && nums[k] != -1) {
                    
                    // Store original values for backtracking
                    long s = nums[j];
                    long t = nums[k];

                    // Mark numbers as used
                    nums[j] = -1;
                    
                    long result;
                    if (operations[i].equals("+")) {
                        result = s + t;
                        // Update nums[k] with the result
                        nums[k] = result;
                    } else { // operations[i] == "*"
                        result = s * t;
                        // Update nums[k] with the result
                        nums[k] = result;
                    }

                    // Check if this is the last operation (i=2)
                    if (i == 2) {
                        if (nums[k] < minAns[0]) {
                            minAns[0] = nums[k];
                        }
                    }

                    // Recurse to the next operation
                    rememberTheNumber(nums, i + 1, operations, minAns);

                    // Backtrack: Restore nums[j] and nums[k]
                    nums[j] = s;
                    nums[k] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read nums (assuming they fit within long)
        String line1 = scanner.nextLine();
        String[] numStrs = line1.split(" ");
        long[] nums = new long[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Long.parseLong(numStrs[i]);
        }

        // Read operations
        String line2 = scanner.nextLine();
        String[] operations = line2.split(" ");

        // Initialize minAns to a very large number (Long.MAX_VALUE)
        // We use a long array wrapper to simulate passing by reference for the minimum answer.
        long[] minAns = new long[1];
        minAns[0] = Long.MAX_VALUE;

        // Start the recursion
        rememberTheNumber(nums, 0, operations, minAns);

        // Print the result
        System.out.println(minAns[0]);
        
        scanner.close();
    }
}