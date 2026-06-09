import java.util.Scanner;
import java.util.Arrays;

public class s259116349 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Primes list (15 primes)
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        int numPrimes = primes.length;

        // Step 1: Calculate divs for i = 1 to 100
        // divs[i-1] will store the prime factorization exponents for i
        int[][] divs = new int[100][numPrimes];

        for
