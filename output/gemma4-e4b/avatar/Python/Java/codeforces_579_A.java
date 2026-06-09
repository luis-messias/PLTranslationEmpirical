import java.util.Scanner;

public class codeforces_579_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read integer n
        int n = scanner.nextInt();
        scanner.close();

        int x = 1;

        // We need to check if log2(n) is an integer.
        // We use Math.log(n) / Math.log(2) to calculate log2(n) safely across Java versions.
        
        // Loop continues as long as log2(n) is not an integer.
        // We check if log2(n) != floor(log2(n))
        
        double log2N = Math.log(n) / Math.log(2);