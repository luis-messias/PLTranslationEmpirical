import java.util.Scanner;

public class s652791025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        if (input.isEmpty()) {
            // Handle empty input case if necessary, though the original Python assumes input exists.
            return;
        }

        // Get the last character and convert it to an integer
        char lastChar = input.charAt(input.length() - 1);
        int n = Character.getNumericValue(lastChar);

        if (n == 2 || n == 4 || n == 5 || n == 7 || n == 9) {
            System.out.println("hon");
        } else if (n == 0 || n == 1 || n == 6 || n == 8) {
            System.out.println("pon");
        } else {
            // This covers n == 3
            System.out.println("bon");
        }
    }
}