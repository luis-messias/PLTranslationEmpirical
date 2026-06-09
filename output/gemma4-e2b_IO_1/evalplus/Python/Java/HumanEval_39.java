import java.util.Random;

public class HumanEval_39 {

    /**
     * Helper function for modular exponentiation (a^b mod m)
     */
    private static long power(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b
