import java.util.Scanner;

public class codeforces_55_B {

    private static long[] ans;
    private static long[] nums;
    private static String[] operations;

    public static void rememberTheNumber(long[] nums, int i, String[] operations, long[] ans) {
        if (i >= 3) {
            return;
        }

        // The loops iterate over indices j and k, which seem to be fixed based on the Python code's range(4).
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
                    
                    // Note: The Python code only handles '+' and '*'.

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

        // Read nums (4 numbers)
        String line1 = scanner.nextLine();
        String[] numStrs = line1.split(" ");
        
        // Initialize nums array to store long values, using -1 as the marker for used numbers
        nums = new long[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Long.parseLong(numStrs[i]);
        }

        // Read operations (3 operators)
        String line2 = scanner.nextLine();
        operations = line2.split(" ");

        // Initialize ans with a very large value
        // Using Long.MAX_VALUE is safer than the specific large number in Python, 
        // as we are minimizing the result.
        ans = new long[]{Long.MAX_VALUE}; 

        // Start the recursion
        rememberTheNumber(nums, 0, operations, ans);

        // Print the result
        System.out.println(ans[0]);

        scanner.close();
    }
}
