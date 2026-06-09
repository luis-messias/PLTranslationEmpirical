import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class s817205687 {

    // Helper function for GCD (Java's Math.gcd handles this)
    // Helper function for LCM
    private static long lcm(long x, long y) {
        if (x == 0 || y == 0) return 0;
        // Use long multiplication to prevent overflow before division
        return Math.abs(x * y) / Math.gcd(x, y);
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
        if (!scanner.hasNextLong()) return;
        List<Long> A_input = new java.util.ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextLong()) {
                A_input.add(scanner.nextLong());
            }
        }

        // 1. 最初、Aの要素は全て偶数。2で割ったものに置き換え
        List<Long> A = A_input.stream()
                            .map(a -> a / 2)
                            .collect(Collectors.toList());

        // 2. 全ての要素について、２で割れる回数が同じでないと題意は満たせない
        Integer countDiv2 = null;
        
        // We need to check the original structure of the numbers relative to powers of 2.
        // The Python code modifies 'a' inside the loop, which is tricky in Java if we want to preserve the original state for the LCM calculation later.
        // We will calculate the power of 2 for each element in A (which are the halved values).
        
        for (long a : A) {
            long current_a = a;
            int cnt = 0;
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
        if (!A.isEmpty()) {
            my_lcm = A.get(0);
            for (int i = 1; i < A.size(); i++) {
                my_lcm = lcm(my_lcm, A.get(i));
            }
        }
        
        // my_lcmがMを超えていたら1つも作れない
        if (my_lcm > M) {
            System.out.println(0);
            return;
        }

        // 4. tmp = M // my_lcm
        long tmp = M / my_lcm;

        // 5. ans = (tmp + 1) // 2
        long ans = (tmp + 1) / 2;

        System.out.println(ans);
        
        scanner.close();
    }
}