import java.util.Scanner;
import java.lang.Math;

public class s817205687 {

    // Calculates Greatest Common Divisor (GCD)
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Calculates Least Common Multiple (LCM)
    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Calculate (a * b) / gcd(a, b) safely to prevent overflow
        // Since a and b are positive, we use Math.abs for robustness.
        // We calculate (a / gcd(a, b)) * b to prevent intermediate overflow.
        return Math.abs(a / gcd(a, b)) * Math.abs(b);
    }

    // Calculates the LCM of all elements in the array
    private static long lcmList(long[] numbers) {
        if (numbers == null || numbers.length == 0) return 1;
        
        long result = 1;
        for (long number : numbers) {
            result = lcm(result, number);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        long M = scanner.nextLong();

        // Read array A
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        scanner.close();

        // 1. Preprocessing: Divide all elements by 2
        long[] A_prime = new long[N];
        for (int i = 0; i < N; i++) {
            A_prime[i] = A[i] / 2;
        }

        // 2. Constraint Check: Check if the number of factors of 2 is constant
        int countDiv2 = -1;
        for (long a : A_prime) {
            int cnt = 0;
            long temp = a;
            // Handle case where a=0 (though inputs are usually positive)
            if (temp == 0) {
                cnt = 0; // 0 has infinite factors, but in this context, we treat it as 0 factors of 2
            } else {
                while (temp > 0 && temp % 2 == 0) {
                    temp /= 2;
                    cnt++;
                }
            }

            if (countDiv2 == -1) {
                countDiv2 = cnt;
            } else if (cnt != countDiv2) {
                System.out.println(0);
                return;
            }
        }

        // 3. Calculate my_lcm (LCM of A_prime)
        long myLcm = lcmList(A_prime);

        // Check if my_lcm exceeds M
        if (myLcm > M) {
            System.out.println(0);
            return;
        }

        // 4. Calculate the answer
        // tmp = M / my_lcm (Number of multiples available)
        long tmp = M / myLcm;

        // ans = (tmp + 1) // 2
        long ans = (tmp + 1) / 2;
        System.out.println(ans);
    }
}
