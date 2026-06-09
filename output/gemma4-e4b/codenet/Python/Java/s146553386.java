import java.util.Scanner;
import java.util.Arrays;

public class s146553386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading n

        // 2. Read the two arrays (a[0] and a[1])
        
        // Read array 0
        String line0 = scanner.nextLine();