import java.util.Scanner;

public class s086522214 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string S
        if (!scanner.hasNextLine()) {
            // Handle case where no input is provided
            return;
        }
        String s = scanner.nextLine();
        
        // Split the string by '/'
        String[] t = s.split("/");
        
        // Check if the split resulted in enough parts (Year/Month/Day format)
        if (t.length < 3) {
            // Handle malformed input if necessary, though based on the Python code, 
            // we assume the format is correct.
            return;
        }
        
        // Concatenate the month (t[1]) and day (t[2])
        String dateStr = t[1] + t[2];
        
        int date;
        try {
            // Convert the concatenated string to an integer
            date = Integer.parseInt(dateStr);
        } catch (NumberFormatException e) {
            // Handle case where month/day parts are not valid numbers
            return;
        }
        
        // Apply the logic from the Python code
        if (date <= 430) {
            System.out.println("Heisei");
        } else {
            System.out.println("TBD");
        }
        
        scanner.close();
    }
}