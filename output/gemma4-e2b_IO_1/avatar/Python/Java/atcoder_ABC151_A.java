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
    // Extracts the first word from the first line of the input string.
    public static List<String> parseInput(String linesAsString) {
        List<String> lines = new java.util.ArrayList<>();

        if (linesAsString == null) {
            debug = false;
            // If input is null, we return an empty list, simulating the Python logic flow where input() is called if None.
            return lines;
        } else {
            // lines = [ e for e in lines_as_string.split ( "\n" ) ] [ 1 : - 1 ]
            String[] lineArray = linesAsString.split("\n");
            
            // The Python slice [1:-1] is highly context-dependent and often results in an empty list 
            // or unexpected behavior if the input is short. We focus on the subsequent extraction logic.
            // We keep the lines array for potential future use, although the core logic relies on lines[0].
            lines.addAll(Arrays.asList(lineArray));
        }

        // c = [ e for e in lines [ 0 ].split ( " " ) ] [ 0 ]
        if (!lines.isEmpty()) {
            String firstLine = lines.get(0);
            // Split the first line by space and take the first token
            String[] parts = firstLine.split(" ");
            if (parts.length > 0) {
                return Arrays.asList(parts[0]);
            }
        }
        return lines;
    }

    // Corresponds to solve
    public static String solve(String c) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int i = alphabet.indexOf(c);
        if (i != -1 && i + 1 < alphabet.length()) {
            return String.valueOf(alphabet.charAt
