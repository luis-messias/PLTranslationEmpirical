public class HumanEval_55 {
    public static int fib(int n) {
        /**
         * Return n-th Fibonacci number.
         * fib(10) = 55
         * fib(1) = 1
         * fib(8) = 21
         */
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }
}
