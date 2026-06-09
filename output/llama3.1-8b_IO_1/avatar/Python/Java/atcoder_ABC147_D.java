import java.util.Scanner;
import java.math.BigInteger;

public class atcoder_ABC147_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        BigInteger A = new BigInteger(String.join("", input));
        long result = 0;
        for (int b = 60; b >= 0; b--) {
            BigInteger bs = A.shiftRight(b).and(BigInteger.ONE);
            result += ((long)bs.longValue() * (N - bs.longValue()) * (1L << b)) % 1000000007;
        }
        System.out.println(result % 1000000007);
    }
}
