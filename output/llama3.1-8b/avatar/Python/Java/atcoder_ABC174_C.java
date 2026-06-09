import java.util.Scanner;
import java.math.BigInteger;

public class atcoder_ABC174_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        BigInteger t = BigInteger.ZERO;
        for (int i = 1; i <= k; i++) {
            t = t.multiply(BigInteger.TEN).add(BigInteger.valueOf(7));
            if (t.mod(BigInteger.valueOf(k)).equals(BigInteger.ZERO)) {
                System.out.println(i);
                break;
            }
        } else {
            System.out.println(-1);
        }
    }
}