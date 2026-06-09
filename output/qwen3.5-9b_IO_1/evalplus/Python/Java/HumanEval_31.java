public class HumanEval_31 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        int n_sqrt = 1;
        while (n_sqrt * n_sqrt < n) {
            n_sqrt++;
        }
        for (int i = 2; i < Math.min(n_sqrt + 1, n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
