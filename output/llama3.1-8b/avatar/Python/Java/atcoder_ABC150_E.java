import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC150_E {
    public static void main(String[] args) {
        int mod = (int) Math.pow(10, 9) + 7;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        Arrays.sort(c);
        reverseArray(c);

        long b = pow(2, 2 * n - 2, mod);
        long a = 2 * b % mod;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += c[i] * (a + i * b);
            ans %= mod;
        }
        System.out.println(ans);
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static long pow(long base, long exponent, int mod) {
        if (exponent == 0)
            return 1;
        else if (exponent % 2 == 0)
            return pow(base * base % mod, exponent / 2, mod);
        else
            return pow(base * base % mod, (exponent - 1) / 2, mod) * base % mod;
    }
}