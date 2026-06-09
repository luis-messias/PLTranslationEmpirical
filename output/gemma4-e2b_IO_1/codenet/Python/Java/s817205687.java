import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s817205687 {

    // Helper function for GCD
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper function for LCM
    private static long lcm(long x, long y) {
        if (x == 0 || y == 0) return 0;
        // Use long multiplication to prevent overflow before division
        // Note: Since x and y are positive, Math.abs is not strictly necessary if inputs are guaranteed positive.
        return Math.abs(x * y) / gcd(x, y);
    }

    private static long lcmList(List<Long> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 1;
        }
        long result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = lcm(result, numbers.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextLong()) return;
        long N = scanner.nextLong();
        if (!scanner.hasNextLong()) return;
        long M = scanner.nextLong();

        // Read array A
        List<Long> A_input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextLong()) {
                A_input.add(scanner.nextLong());
            }
        }

        // 1. 最初、Aの要素は全て偶数。2で割ったものに置き換え
        List<Long> A = new ArrayList<>();
        for (long a : A_input) {
            A.add(a / 2);
        }

        // 2. 全ての要素について、２で割れる回数が同じでないと題意は満たせない
        Integer countDiv2 = null;
        
        for (long a : A) {
            long current_a = a;
            int cnt = 0;
            // Count how many times 'a' is divisible by 2
            while (current_a % 2 == 0) {
                current_a /= 2;
                cnt++;
            }
            
            // 1個目は無条件で保存
            if (countDiv2 == null) {
                countDiv2 = cnt;
            } 
            // 2個目からチェック
            else if (cnt != countDiv2) {
                System.out.println(0);
                return;
            }
        }

        // 3. my_lcm = Aの全要素の最小公倍数。
        long my_lcm = 1;
        if (!A.isEmpty
