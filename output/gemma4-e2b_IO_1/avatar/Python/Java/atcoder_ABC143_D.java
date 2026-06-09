import java.util.Scanner;

public class atcoder_ABC143_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line
        String line = scanner.nextLine();
        
        // Split the line by spaces to get the numbers
        String[] parts = line.split(" ");
        
        // Convert the parts to integers
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        
        // Calculate the sum of the numbers
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        // Print the sum
        System.out.println(sum);
    }
}
