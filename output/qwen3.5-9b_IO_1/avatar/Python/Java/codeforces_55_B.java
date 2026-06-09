import java.util.Scanner;

public class codeforces_55_B {
    static long[] ans;
    static int[] nums;
    static String[] operations;
    
    public static void rememberTheNumber(int[] nums, int i, String[] operations, long[] ans) {
        if (i >= 3) {
            return;
        }
        for (int j = 0; j < 4; j++) {
            for (int k = j + 1; k < 4; k++) {
                if (nums[j] != -1 && nums[k] != -1) {
                    long s = nums[j];
                    nums[j] = -1;
                    long t = nums[k];
                    if (operations[i].equals("+")) {
                        nums[k] = s + t;
                    } else if (operations[i].equals("*")) {
                        nums[k] = s * t;
                    }
                    if (i == 2 && nums[k] < ans[0]) {
                        ans[0] = nums[k];
                    }
                    rememberTheNumber(nums, i + 1, operations, ans);
                    nums[j] = (int)s;
                    nums[k] = (int)t;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = scanner.nextInt();
        }
        operations = new String[3];
        for (int i = 0; i < 3; i++) {
            operations[i] = scanner.next();
        }
        ans = new long[1];
        ans[0] = 10000000000000000000000000L;
        rememberTheNumber(nums, 0, operations, ans);
        System.out.println(ans[0]);
    }
}
