import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class codeforces_400_A {

    /**
     * Checks if there is a column in the conceptual matrix formed by slicing the pattern 's'
     * into blocks of size 'a' such that the sum of elements in that column equals 'b'.
     * This means all elements in that column must be 1.
     * 
     * @param s The pattern array (length 12).
     * @param a The step size (number of columns).
     * @param b The number of elements per column (length of the column).
     * @return True if such a column exists, false otherwise.
     */
    private static boolean help(int[] s, int a, int b) {
        // We check 'a' columns, indexed 0 to a-1.
        for (int start_index = 0; start_index < a; start_index++) {
            int current_sum = 0;
            boolean all_ones = true;
            
            // Iterate down the column: s[start_index], s[start_index + a], s[start_index + 2a], ...
            for (int
