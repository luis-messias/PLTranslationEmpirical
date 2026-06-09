public class atcoder_AGC034_B {
    public static void main(String[] args) {
        int num = 123456789;
        System.out.println(sumOfDigits(num));
    }

    /**
     * This method calculates the sum of all digits in a given number.
     *
     * @param num The input number.
     * @return The sum of all digits in the number.
     */
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
