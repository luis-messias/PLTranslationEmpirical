import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class atcoder_ABC150_D {

    // Helper function for GCD (Greatest Common Divisor)
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Helper function for LCM (Least Common Multiple)
    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // LCM(a, b) = |a * b| / GCD(a, b)
        return Math.abs(a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n and num (First line)
        String line1 = br.readLine();
        if (line1 == null || line1.isEmpty()) return;
        String[] firstLine = line1.split(" ");
        long n = Long.parseLong(firstLine[0]);
        long num = Long.parseLong(firstLine[1]);

        // Read the set of numbers (Second line)
        String line2 = br.readLine();
        if (line2 == null || line2.isEmpty()) {
            // Handle case where num set is empty
            System.out.println(0);
            return;
        }
        String[] numStrings = line2.split(" ");
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
            // Use a temporary variable to simulate modification of the loop variable i
            long currentI = i;
            
            for (int j = 1; j < 30; j++) {
                currentI /= 2;
                if (currentI % 2 != 0) {
                    twoTimesSet.add(j);
                    break;
                }
            }
            
            // Check the condition that determines if the loop breaks
            if (twoTimesSet.size() != 1) {
                System.out.println(0);
                shouldBreak = true;
                break;
            }
        }

        // Python's for...else structure: execute this block only if the loop did not break
        if (!shouldBreak) {
            List<Long> numList = new ArrayList<>(numSet);
            
            if (numList.isEmpty()) {
                // If the set was empty, the LCM calculation is undefined/trivial. 
                // Based on the problem context, if numSet is empty, we might assume a default behavior, 
                // but following the logic, if numSet is empty, the loop doesn't run, and we proceed.
                // If numSet is empty, the LCM calculation below will fail if we don't handle it.
                // Assuming the input guarantees at least one element if we reach this point, 
                // or that the calculation should handle it gracefully.
                // Since the original Python code assumes num_list[0] exists if the loop completes, 
                // we assume numSet is non-empty if we reach here.
            } else {
                long lcmVal = numList.get(0);
                for (int i = 1; i < numList.size(); i++) {
                    lcmVal = lcm(lcmVal, numList.get(i));
                }
                
                // Calculate (num - lcm // 2) // (lcm) + 1
                // Note: Integer division // in Python corresponds to standard long division in Java
                long
