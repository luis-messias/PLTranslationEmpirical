import java.util.Arrays;
import java.util.Scanner;

public class s706119740 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the line of input
        String line = scanner.nextLine();
        
        // Split the input string by spaces and convert to an array of integers
        String[] parts = line.split(" ");
        int[] candy = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            candy[i] = Integer.parseInt(parts[i]);
        }
        
        // Sort the array
        Arrays.sort(candy);
        
        // Check the condition (assuming at least 3 elements are present)
        if (candy.length >= 3 && candy[0] + candy[1] == candy[2]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}