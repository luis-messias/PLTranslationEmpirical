import java.util.Scanner;

public class s993625131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line, equivalent to S = list(input())
        String s = scanner.nextLine();

        int count = 0;
        int record = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // Check if the character is one of the valid nucleotides
            if (current == 'A' || current == 'C' || current == 'G' || current == 'T') {
                count += 1;
            } else {
                // If the character is not a valid nucleotide, check if the current count is the new record
                if (count > record) {
                    record = count;
                }
                // Reset count
                count = 0;
            }
        }

        // Check if the final count is the new record
        if (count > record) {
            record = count;
        }

        System.out.println(record);
        
        scanner.close();
    }
}