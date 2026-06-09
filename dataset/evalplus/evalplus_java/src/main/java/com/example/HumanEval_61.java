public class HumanEval_61 {
    public static boolean correctBracketing(String brackets) {
        int cnt = 0;
        for (char x : brackets.toCharArray()) {
            if (x == '(') {
                cnt++;
            }
            if (x == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
