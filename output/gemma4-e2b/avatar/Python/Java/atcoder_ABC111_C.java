import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC111_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the sequence x
        // The Python code reads the rest of the line for x.
        // We need to read the next line containing the space-separated numbers.
        // Since the input format is ambiguous (n then x), we assume x is on the next line.
        List<Integer> xList = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    xList.add(Integer.parseInt(part));
                }
            }
        }
        
        // If the input reading logic in Python implies reading all numbers on one line after n, 
        // we need to adjust how we read x. Let's re-read the input based on typical competitive programming style 
        // where n is followed by the data.
        
        // Re-reading input based on the structure: n is read, then the rest of the input is the sequence x.
        // If the input was provided as a single block, we must assume the structure is:
        // Line 1: n
        // Line 2: x1 x2 x3 ...
        
        // Since the provided Python code uses input() twice, let's assume standard reading:
        //