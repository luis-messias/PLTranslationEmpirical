import java.util.Scanner;

public class s031917494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the integer input
        int n = scanner.nextInt();

        // Calculate the number of repetitions: abs(int(input()) - 25)
        int repetitions = Math.abs(n - 25);

        // Construct the repeated string: ' Eve' repeated 'repetitions' times
        // Using StringBuilder for efficient string construction
        StringBuilder repeatedPart = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            repeatedPart.append(" Eve");
        }

        // Print the final result: 'Christmas' + repeatedPart
        System.out.println("Christmas" + repeatedPart.toString());
    }
}