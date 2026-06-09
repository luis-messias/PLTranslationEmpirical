import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class atcoder_ABC114_C {
    static int N;

    static int aaa(String n) {
        int currentN = Integer.parseInt(n);

        if (currentN > N) {
            return 0;
        }

        // Check if the set of digits of n is exactly {'7', '5', '3'}
        Set<Character> digits = new HashSet<>();
        for (char c : n.toCharArray()) {
            digits.add(c);
        }

        Set<Character> required = new HashSet<>(Arrays.asList('7', '5', '3'));

        int ans = 0;
        if (digits.equals(required)) {
            ans = 1;
        } else {
            ans = 0;
        }

        // Recursive calls
        for (char i : new char[]{'7', '5', '3'}) {
            ans += aaa(n + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N from input
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
        } else {
            // Handle case where input reading fails
            return;
        }

        // Calculate and print aaa('0')
        System.out.println(aaa("0"));
        
        scanner.close();
    }
}