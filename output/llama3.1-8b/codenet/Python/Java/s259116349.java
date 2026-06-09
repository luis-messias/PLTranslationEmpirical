import java.util.Scanner;

public class s259116349 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        int[][] divs = new int[100][primes.length];
        for (int i = 1; i < 101; i++) {
            int[] tmp = new int[primes.length];
            for (int j = 0; j < primes.length; j++) {
                int p = primes[j];
                while (i % p == 0) {
                    i /= p;
                    tmp[j]++;
                }
            }
            divs[i - 1] = tmp;
        }

        int[] divsum = new int[primes.length];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < primes.length; j++) {
                divsum[j] += divs[i - 1][j];
            }
        }

        int ans = 0;

        ans += count(divsum, 75);
        ans += count(divsum, 15) * (count(divsum, 5) - 1);
        ans += count(divsum, 25) * (count(divsum, 3) - 1);
        ans += count(divsum, 5) * (count(divsum, 5) - 1) * (count(divsum, 3) - 2) / 2;

        System.out.println(ans);
    }

    public static int count(int[] divsum, int n) {
        int count = 0;
        for (int i : divsum) {
            if (i >= n - 1) {
                count++;
            }
        }
        return count;
    }
}