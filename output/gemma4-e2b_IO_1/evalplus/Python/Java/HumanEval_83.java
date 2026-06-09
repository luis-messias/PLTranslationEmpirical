class Solution {
    public static int starts_one_ends(int n) {
        if (n == 1) {
            return 1;
        }
        // The formula is 18 * 10^(n - 2)
        // Use long for intermediate calculation to prevent overflow
        long exponent = n - 2;
        long powerOfTen = (long) Math.pow(10, exponent);
        long result = 18 * powerOfTen;
        return (int) result;
    }
}
