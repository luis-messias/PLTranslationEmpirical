import java.util.Scanner;
import java.math.BigInteger;

public class s554858080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        StringBuilder numBuilder = new StringBuilder();
        
        // Read all tokens from the input line and concatenate them
        while (scanner.hasNext()) {
            String token = scanner.next();
            numBuilder.append(token);
        }
        
        String numStr = numBuilder.toString();
        
        scanner.close();

        if (numStr.isEmpty()) {
            // Handle empty input case if necessary, though typically input is guaranteed.
            return;
        }

        // Use BigInteger to handle potentially very large numbers, matching Python's behavior.
        BigInteger num = new BigInteger(numStr);
        
        // Check if num is divisible by 4
        BigInteger four = BigInteger.valueOf(4);
        
        if (num.remainder(four).equals(BigInteger.ZERO)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}