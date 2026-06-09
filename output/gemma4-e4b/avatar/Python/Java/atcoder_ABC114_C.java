import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class atcoder_ABC114_C {

    private static long N;

    public static long aaa(String n) {
        // 1. Constraint Check
        long currentNum;
        try {
            currentNum = Long.parseLong(n);
        } catch (NumberFormatException e) {
            // Should not happen if input is constructed correctly
            return 0;
        }

        if (currentNum > N) {
            return 0;
        }

        // 2. Calculate initial ans (Check if digits are exactly '7', '5', '3')
        Set<Character> digits = new HashSet<>();
        for (char c : n.toCharArray()) {
            digits.add(c);
        }

        long ans = 0;
        // Check if the set of unique digits is exactly {'7', '5', '3'}
        if (digits.size() == 3 && digits.contains('7') && digits.contains('5') && digits.contains('3')) {
            ans = 1;
        }

        // 3. Recursive Step
        long totalAns = ans;
        String[] digitsToAppend = {"7", "5", "3"};

        for (String i : digitsToAppend) {
            totalAns += aaa(n + i);
        }

        return totalAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N from standard input
        if (scanner.hasNextLong()) {
            N = scanner.nextLong();
        } else {
            // Handle case where input might be missing or invalid
            N = -1; 
        }
        scanner.close();

        // Call aaa('0')
        System.out.println(aaa("0"));
    }
}