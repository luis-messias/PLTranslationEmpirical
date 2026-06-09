import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC164_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read input s and set l
        // Assuming input is read as a string s, and l is fixed at 2019 based on the Python code structure.
        // Since the Python code uses input(), we read the next token/line.
        String s = scanner.next();
        int l = 2019;

        // Step 2: Initialize m, a, r
        // m = [1, 0, 0, ..., 0] of size l
        int[] m = new int[l];
        m[0] = 1;
        
        long a = 0;
        long r = 0;

        // Step 3: Iterate over the reversed digits of s
        // s[::-1] in Python means iterating backwards.
        // We iterate from the last character of s to the first.
        
        // We iterate over the characters of s in reverse order.
        for (int i = 0; i < s.length(); i++) {
            // e is the digit at index (s.length() - 1 - i) in s, which corresponds to the i-th element in the reversed sequence.
            // s[s.length() - 1 - i] is the digit we are processing.
            int e = Character.getNumericValue(s.charAt(s.length() - 1 - i));
            
            // Python's enumerate(s[::-1]) iterates over the reversed string.
            // Let's stick to the Python logic structure: iterate over reversed digits.
            
            // Re-evaluating the Python loop: for i, e in enumerate(s[::-1]):
            // i = 0 corresponds to the last digit of s.
            // e = s.charAt(s.length() - 1)
            
            // Let's iterate backwards over s directly to get the digits in the order they appear in the loop (i=0, 1, 2, ...)
            
            // We need to iterate over s backwards.
        }
        
        // Resetting variables for clarity based on Python logic:
        a = 0;
        r = 0;
        
        // Iterate over the reversed string s
        String reversedS = new StringBuilder(s).reverse().toString();
        
        for (int i = 0; i < reversedS.length(); i++) {
            int e = Character.getNumericValue(reversedS.charAt(i));
            
            // a += int(e) * pow(10, i, l)
            // pow(10, i, l) is (10^i) % l
            long powerOf10ModL = power(10, i, l);
            a += (long)e * powerOf10ModL;
            
            // r += m[a % l]
            int index = (int)(a % l);
            r += m[index];
            
            // m[a % l] +=
