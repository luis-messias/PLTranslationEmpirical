import java.util.*;

public class codeforces_55_B {
    public static void rememberTheNumber(int[] nums, int i, String[] operations, long[] ans) {
        if (i >= 3) {
            return;
        }
        for (int j = 0; j < 4; j++) {
            for (int k = j + 1; k < 4; k++) {
                if (nums[j] != -1 && nums[k] != -1) {
                    int s = nums[j];
                    nums[j] = -1;
                    int t = nums[k];
                    if (operations[i].equals("+")) {
                        nums[k] = s + t;
                    } else if (operations[i].equals("*")) {
                        nums[k] = s * t;
                    }
                    if (i == 2 && nums[k] < ans[0]) {
                        ans[0] = nums[k];
                    }
                    rememberTheNumber(nums, i + 1, operations, ans);
                    nums[j] = s;
                    nums[k] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        input = scanner.nextLine();
        String[] operations = input.split(" ");
        long[] ans = {Long.MAX_VALUE};
        rememberTheNumber(nums, 0, operations, ans);
        System.out.println(ans[0]);
    }
}
