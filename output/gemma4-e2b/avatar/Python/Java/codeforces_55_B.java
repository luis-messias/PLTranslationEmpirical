import java.util.Scanner;
import java.util.Arrays;

public class codeforces_55_B {

    // We use long for the result array to handle potentially large numbers, 
    // similar to the large initial value in the Python code.
    private static long[] ans;
    private static int[] nums;
    private static String[] operations;

    public static void rememberTheNumber(int[] nums, int i, String[] operations, long[] ans) {
        if (i >= 3) {
            return;
        }

        // The loops iterate over indices j and k, which seem to be fixed based on the Python code's range(4).
        // j ranges from 0 to 3, k ranges from j+1 to 3.
        for (int j = 0; j < 4; j++) {
            for (int k = j + 1; k < 4; k++) {
                // Check if both elements are valid (not -1)
                if (nums[j] != -1 && nums[k] != -1) {
                    long s = nums[j];
                    nums[j] = -1; // Mark nums[j] as used
                    long t = nums[k];
                    
                    long result = 0;
                    
                    // Perform the operation based on operations[i]
                    if (operations[i].equals("+")) {
                        result = s + t;
                    } else if (operations[i].equals("*")) {
                        result = s * t;
                    }
                    // Note: The Python code only handles '+' and '*'. We assume this is sufficient based on the provided snippet.

                    nums[k] = result;

                    // Update ans[0] if i == 2 and the result is smaller
                    if (i == 2 && nums[k] < ans[0]) {
                        ans[0] = nums[k];
                    }

                    // Recursive call
                    rememberTheNumber(nums, i + 1, operations, ans);

                    // Backtrack: restore nums[j] and nums[k]
                    nums[j] = s;
                    nums[k] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read nums
        // Assuming input is space-separated integers on the first line
        String line1 = scanner.nextLine();
        String[] numStrs = line1.split(" ");
        nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        // Read operations
        // Assuming input is space-separated operators on the second line
        String line2 = scanner.nextLine();
        operations = line2.split(" ");

        // Initialize ans with a very large value
        // Using Long.MAX_VALUE might be safer, but sticking to the Python initialization style for direct translation.
        ans = new long[]{Long.MAX_VALUE}; 

        // Start the recursion
        rememberTheNumber(nums, 0, operations, ans);

        // Print the result
        System.out.println(ans[0]);

        scanner.close();
    }
}