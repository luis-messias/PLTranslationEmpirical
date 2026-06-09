import java.util.Scanner;

public class s840967243 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MOD = (int) Math.pow(10, 9) + 7;
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long result = Math.max(2 - m + n, 0);
        if (result > 0) {
            result *= factorial(n);
            result %= MOD;
            result *= factorial(m);
            result %= MOD;
        }

        System.out.println(result);
    }

    public static long factorial(int number) {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
            result %= Math.pow(10, 9) + 7;
        }
        return result;
    }
}