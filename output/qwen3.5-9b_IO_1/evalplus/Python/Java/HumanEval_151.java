import java.util.List;

public class HumanEval_151 {
    public static int doubleTheDifference(List<Integer> lst) {
        int ans = 0;
        for (int num : lst) {
            if (num % 2 == 1 && num > 0) {
                ans += num * num;
            }
        }
        return ans;
    }
}
