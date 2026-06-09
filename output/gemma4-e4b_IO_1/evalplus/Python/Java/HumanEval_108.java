class Solution {
    /**
     * Helper function to determine if a single number contributes 1 or 0 to the count.
     * The logic follows the Python implementation: the first digit is negative if the number is negative,
     * and subsequent digits are positive.
     */
    private static int judge(int x) {
        // Handle the special case of 0 immediately
        if (x == 0) {
            return 0;
        }

        // Get the absolute value string to process digits
        String s = String.valueOf(Math.abs(x));
        char[] chars = s.toCharArray();
        
        int sum = 0;
        
        // Calculate the sum of all digits as if they were positive
        for (char c : chars) {
            sum += Character.getNumericValue(c);
        }
        
        // If the original number was negative, the first digit contributes negatively.
        // Since we added it positively above, we must subtract 2 * (first digit) 
        // to make the net contribution negative.
        if (x < 0) {
            int firstDigit = Character.getNumericValue(chars[0]);
            sum -= 2 * firstDigit;
        }
        
        // Return 1 if the final sum is greater than 0, otherwise 0.
        return sum > 0 ? 1 : 0;
    }

    /**
     * Counts the number of elements in the array whose signed sum of digits is greater than 0.
     * @param arr The array of integers.
     * @return The count of elements satisfying the condition.
     */
    public static int count_nums(int[] arr) {
        int totalCount = 0;
        for (int x : arr) {
            totalCount += judge(x);
        }
        return totalCount;
    }
}
