import java.util.Scanner;
import java.util.Arrays;

public class s259116349 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Primes list
        int[] primes = {2, 3, 5, 7,