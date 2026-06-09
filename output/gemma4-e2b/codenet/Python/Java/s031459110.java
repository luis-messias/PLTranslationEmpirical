import java.util.Scanner;

public class s031459110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        
        // Read c (the string)
        if (!scanner.hasNextLine()) return;
        String c = scanner.next(); // Assuming c is read on the next line, or reading the next token if input is space separated. 
                                   // Since Python input() reads line by line, we read the rest of the line.
        
        // If the input format is strictly N on line 1, c on line 2:
        // We need to handle the potential newline left after reading N.
        // Since the original Python used input() twice, we assume standard line-by-line reading.
        
        // Re-reading input handling for robustness based on typical CP style:
        // If N is read, the next token might be the start of C.
        // Let's assume the input stream provides N, then C on the next line.
        
        // Resetting input reading based on typical structure:
        // N is read first.
        // C is read second.
        
        // Since the provided Python code uses input() twice, we must ensure we read N and C correctly.
        // If we use Scanner, we need to handle the transition.
        
        // Let's re-read N and C assuming standard input stream behavior where N is an integer and C is a string.
        
        // If we strictly follow the Python structure where input() reads tokens:
        // N = int(input())