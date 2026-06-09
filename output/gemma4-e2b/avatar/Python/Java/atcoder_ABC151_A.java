import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class atcoder_ABC151_A {

    private static boolean debug = false;

    public static void log(String text) {
        if (debug) {
            System.out.println(text);
        }
    }

    // Corresponds to parse_input
    // Returns a list containing the single character extracted.
    public static List<String> parseInput(String linesAsString) {
        List<String> lines = new java.util.ArrayList<>();

        if (linesAsString == null) {
            debug = false;
            // In Python, input() reads from stdin. In Java, we assume linesAsString is provided or we handle reading it externally.
            // Since the Python code calls input() directly, we must assume the caller handles reading the input stream.
            // For a direct translation, we simulate the logic based on the provided string.
            // If linesAsString is null, the Python code reads input(). We cannot replicate interactive input directly here without Scanner setup.
            // We will assume linesAsString is the input string provided to this function.
            // If linesAsString is null, we cannot proceed without external input setup.
            // Based on the Python structure, if lines_as_string is None, it reads input(). We must adapt this to a runnable Java program.
            // For this translation, we assume the input is passed in.
            return lines;
        } else {
            // lines = [ e for e in lines_as_string.split ( "\n" ) ] [ 1 : - 1 ]
            String[] lineArray = linesAsString.split("\n");
            // The slice [1:-1] on a list of lines usually means skipping the first and last element.
            // If lines_as_string is a single line, this results in an empty list.
            // Given the context, the intent seems to be processing the input lines.
            // We will simplify this to just splitting and taking the relevant part based on the subsequent logic.
            lines.addAll(Arrays.asList(lineArray));
        }

        // c = [ e for e in lines [ 0 ].split ( " " ) ] [ 0 ]
        if (!lines.isEmpty()) {
            String firstLine = lines.get(0);
            String[] parts = firstLine.split(" ");
            if (parts.length > 0) {
                // Take the first element
                return Arrays.asList(parts[0]);
            }
        }
        return lines;
    }

    // Corresponds to solve
    public static String solve(String c) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int i = alphabet.indexOf(c);
        if (i != -1) {
            if (i + 1 < alphabet.length()) {
                return alphabet.charAt(i + 1);
            }
        }
        return ""; // Handle case where character is not found or is 'z'
    }

    // Corresponds to main
    public static void main(String[] args) {
        // In the Python code, input() is called if lines_as_string is None.
        // We need to read input from the console in Java.
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";

        // Simulate reading input based on the Python logic flow.
        // The Python code seems to expect the input to be read once.
        if (scanner.hasNextLine()) {
            inputLine = scanner.nextLine();
        }

        // The Python code calls parse_input() with no arguments if input() is used.
        // We pass the read input line.
        List<String> resultList = parseInput(inputLine);

        String result;

        // Python logic: result = solve ( * parse_input ( ) )
        if (!resultList.isEmpty()) {
            String c = resultList.get(0);
            result = solve(c);
        } else {
            result = "";
        }