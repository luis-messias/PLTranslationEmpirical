import java.util.Scanner;

public class s398580870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int k = scanner.nextInt();

                if (k % 2 == 1) {
                    // (n // k) ** 3
                    long quotient = n / k;
                    long result = quotient * quotient * quotient;
                    System.out.println(result);
                } else {
                    // (n // k) ** 3 + ((n + k // 2) // k) ** 3
                    long term1 = (long)(n / k) * (n / k) * (n / k);
                    
                    int k_div_2 = k / 2;
                    int inner_quotient = (n + k_div_2) / k;
                    long term2 = (long)inner_quotient * inner_quotient * inner_quotient;
                    
                    System.out.println(term1 + term2);
                }
            }
        }
        scanner.close();
    }
}