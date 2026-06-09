import java.util.Scanner;
import java.math.BigInteger;

public class codeforces_617_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // consume first input line (length)
        String a = scanner.nextLine().replaceAll("\\s+", ""); // read and remove spaces
        
        if (a.indexOf('1') == -1) {
            System.out.println(0);
        } else {
            String trimmed = a.replaceAll("^0+|0+$", "");
            String[] parts = trimmed.split("1");
            BigInteger product = BigInteger.ONE;
            for (String part : parts) {
                int count0 = 0;
                for (char c : part.toCharArray()) {
                    if (c == '0') {
                        count0++;
                    }
                }
                product = product.multiply(BigInteger.valueOf(count0 + 1));
            }
            System.out.println(product);
        }
    }
}
