import java.util.Scanner;

public class s666154520 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n as long to safely compare against i*i, which can reach 10^10
        long n = scanner.nextLong();
        scanner.close();

        // Loop from i = 1 up to 99999 (10^5 - 1)
        for (int i = 1; i < 100000; i++) {
            // Calculate i*i using long to prevent integer overflow
            long i_squared = (long)i * i;

            if (i_squared > n) {
                // Calculate and print (i-1) * (i-1)
                long result = (long)(i - 1);
                long final_result = result * result;
                System.out.println(final_result);
                return; // Exit the program
            }
        }
    }
}