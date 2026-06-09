public class HumanEval_155 {
    public static int[] evenOddCount(int num) {
        int even = 0;
        int odd = 0;
        String numStr = String.valueOf(num);
        for (char ch : numStr.toCharArray()) {
            if (ch == '0' || ch == '2' || ch == '4' || ch == '6' || ch == '8') {
                even++;
            } else if (ch == '1' || ch == '3' || ch == '5' || ch == '7' || ch == '9') {
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}
