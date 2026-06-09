class Solution {
    public static int fib4(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 0;
        }

        // Initialize based on fib4(0) to fib4(3)
        // a = fib4(i-4)
        // b = fib4(i-3)
        // c = fib4(i-2)
        // d = fib4(i-1)
        
        int a = 0; // fib4(0)
        int b = 0; // fib4(1)
        int c = 2; // fib4(2)
        int d = 0; // fib4(3)

        for (int i = 4; i <= n; i++) {
            // Calculate fib4(i) = fib4(i-1) + fib4(i-2) + fib4(i-3) + fib4(i-4)
            // Update: (a, b, c, d) becomes (b, c, d, a + b + c + d)
            int next = a + b + c + d;
            a = b;
            b = c;
            c = d;
            d = next;
        }
        return d;
    }
}
