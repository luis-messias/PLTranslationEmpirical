public class HumanEval_139 {
    public static long specialFactorial(int n) {
        long fac = 1;
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            fac *= i;
            ans *= fac;
        }
        return ans;
    }
}
