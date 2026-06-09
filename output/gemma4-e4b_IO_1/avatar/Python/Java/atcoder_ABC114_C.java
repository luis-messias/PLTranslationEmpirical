import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class atcoder_ABC114_C {

    private static long N;
    private static Map<String, Long> memo = new HashMap<>();

    public static long aaa(String n) {
        // 1. Check memoization table
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // 2. Constraint Check (Base Case)
        long currentNum;
        try {
            // Since N is read as a long, and the maximum length of n is constrained by N, 
            // parsing n to long is safe here.
            currentNum = Long.parseLong(n);
        } catch (NumberFormatException e) {
            // Should not happen given the problem constraints
            return 0;
        }

        if (currentNum > N) {
            return 0;
        }

        // 3. Calculate initial ans (Check if digits are exactly '7', '5', '3')
        Set<Character> digits = new HashSet<>();
        for (char c : n.toCharArray()) {
            digits.add(c);
        }

        long ans = 0;
        // Check if the set of unique digits is exactly {'7', '5', '3'}
        if (digits.size() == 3 && digits.contains('7') && digits.contains('5') && digits.contains('3')) {
            ans = 1;
        }

        // 4. Recursive Step
        long totalAns = ans;
        String[] digitsToAppend = {"7", "5", "3"};

        for (String i : digitsToAppend) {
            totalAns += aaa(n + i);
        }

        // 5. Store and return
        memo.put(n, totalAns);
        return totalAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N from standard input
        if (scanner.hasNextLong()) {
            N = scanner.nextLong();
        } else {
            N = -1; 
        }
        scanner.close();
