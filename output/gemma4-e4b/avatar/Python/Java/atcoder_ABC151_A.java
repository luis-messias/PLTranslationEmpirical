import java.util.Scanner;

public class atcoder_ABC151_A {

    // Global state equivalent (though not strictly necessary for this simplified Java version)
    private static boolean debug = false;

    // Equivalent to log(text)
    private static void log(String text) {
        if (debug) {
            System.out.println(text);
        }
    }

    /**
     * Parses the input. In the context of the original Python code, 
     * this reads a single line from standard input and extracts the first word.
     * @return The input string (the first word).
     */
    private static String parseInput() {
        // Since the original Python code uses input() when no argument is provided, 
        // we read from System.in in the main method and pass it here, or handle it directly.
        // For simplicity and adherence to the single input line usage, we assume the caller handles the Scanner.
        return null; // Placeholder, actual input reading happens in main
    }

    /**
     * Solves the problem: finds the next character in the alphabet.
     * @param inputChar The character input (e.g., 'a').
     * @return The next character (e.g., 'b').
     */
    private static char solve(char inputChar) {
        // Check for wrap-around (z -> a), although the original Python code would error on 'z'.
        // We implement standard alphabetical behavior.
        if (inputChar == 'z') {
            return 'a';
        }
        
        // Simple character arithmetic for the next character
        return (char) (inputChar + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            // Handle case where no input is provided
            return;
        }
        
        String inputLine = scanner.nextLine();
        scanner.close();

        // 1. Extract the first word/character from the input line (mimicking parse_input)
        String firstWord = "";
        if (inputLine != null && !inputLine.trim().isEmpty()) {
            // Split by space and take the first element
            String[] words = inputLine.trim().split("\\s+");
            if (words.length > 0) {
                firstWord = words[0];
            }
        }

        if (firstWord.isEmpty()) {
            return;
        }

        // 2. Get the character to solve
        char inputChar = firstWord.toLowerCase().charAt(0);

        // 3. Solve and print the result
        char result = solve(inputChar);
        
        // Print the result character
        System.out.println(result);
    }
}