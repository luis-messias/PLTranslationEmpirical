import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.Arrays;

public class atcoder_ABC150_D {

    // Helper function for GCD (Greatest Common Divisor)
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n and num (First line)
        String[] firstLine = br.readLine().split(" ");
        long n = Long.parseLong(firstLine[0]);
        long num = Long.parseLong(firstLine[1]);

        // Read the set of numbers (Second line)
        String[] numStrings = br.readLine().split(" ");
        Set<Long> numSet = new HashSet<>();
        for (String s : numStrings) {
            if (!s.isEmpty()) {
                numSet.add(Long.parseLong(s));
            }
        }

        Set<Integer> twoTimesSet = new HashSet<>();
        boolean shouldBreak = false;

        // Simulate the Python for...else loop structure
        for (long i : numSet) {
            // We must use a local copy of i for modification inside the loop
            long currentI = i;