import java.util.Scanner;
import java.math.BigInteger;

public class codeforces_617_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int count1 = a.length() - a.replace("0", "").length();
        if (count1 == 0) {
            System.out.println(0);
        } else {
            String[] parts = a.replaceAll("^0+|0+$", "").split("1");
            BigInteger result = BigInteger.ONE;
            for (String part : parts) {
                result = result.multiply(BigInteger.valueOf(part.length()));
            }
            System.out.println(result.toString());
        }
    }
}