package com.example;
public class HumanEval_65 {

    public static String circular_shift(int x, int shift) {
        char[] result = String.valueOf(x).toCharArray();
        
        if (shift > result.length()) return new StringBuilder(result).reverse().toString();

        shift %= result.length;

        if (shift == 0) {
            return new String(result);
        } else {
            reverse(result, 0, result.length - 1);

            int startIndex = Math.max(0, result.length() - shift);
            
            // Remove leading zeros
            while(startIndex < result.length && result[startIndex] == '0') {
                startIndex++;
            }

            String shiftedStr = new String(Arrays.copyOfRange(result, startIndex, result.length));
            
            return shiftedStr + new StringBuilder(shiftedStr).reverse().toString();
        }
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(circular_shift(12, 1)); // Output: "21"
        System.out.println(circular_shift(12, 2)); // Output: "12"
    }
}
