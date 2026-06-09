public class HumanEval_98 {
    public static int countUpper(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                cnt++;
            }
        }
        return cnt;
    }
}
