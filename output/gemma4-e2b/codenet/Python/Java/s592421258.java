import java.util.Scanner;

public class s592421258 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input I. Assuming I is an integer based on the context of multiplication and list indexing.
        if (scanner.hasNextInt()) {
            int I = scanner.nextInt();
            // s = I * 2; (This step is often ignored if the check is purely based on I's parity)
            // The expression ['No','Yes'][I()in s] implies a boolean check resulting in an index (0 or 1).
            // We interpret this as checking if I is even (I % 2 == 0).
            // If I is even, the result is 'Yes' (index 1). If I is odd, the result is 'No' (index 0).
            
            // Check if I is even
            boolean isEven = (I % 2 == 0);
            
            // Index calculation: If isEven is true (1), index is 1. If false (0), index is 0.
            int index = isEven ? 1 : 0;
            
            // Print the result
            System.out.println(new String[]{"No", "Yes"}[index]);
        }
        scanner.close();
    }
}