import java.util.Scanner;
import java.util.regex.Pattern;

public class codeforces_70_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading n

        // Read the sentence string
        if (!scanner.hasNextLine()) {
            // If no string input, we assume the initial count of 1 is the answer if n >= 0
            // Based on the Python structure, if input is empty, the loop won't run, and 1 will be printed.
            System.out.println(1);
            return;
        }
        String inputString = scanner.nextLine();