import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class codeforces_651_A {

    // Global scanner instance for input handling
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Handle the initial input and calculation (mimicking the first two lines of Python)
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Python: ( ( y - x ) % 3 > 0 ) evaluates to 1 if true, 0 if false.
            // We use a ternary operator to achieve this integer conversion.
            int condition = ((y - x) % 3 > 0) ? 1 : 0;

            // Calculate max(x + y - 3 + condition, 0)
            int result = Math.max(x + y - 3 + condition, 0);
            System.out.println(result);
        }

        // 2. Define utility methods (mimicking the lambda functions)
        // Note: In a real Java application, these methods would typically take the Scanner object.
    }

    /**
     * num_inp = lambda : int ( input ( ) )
     */
    public static int num_inp() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0; // Default or error handling
    }

    /**
     * arr_inp = lambda : list ( map ( int , input ( ).split ( ) ) )
     */
    public static List<Integer> arr_inp() {
        if (!scanner.hasNext()) {
            return new ArrayList<>();
        }
        
        // Read the entire line and parse space-separated integers
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return Arrays.stream(line.split("\\s+"))
                     .map(Integer::parseInt)
                     .collect(java.util.stream.Collectors.toList());
    }

    /**
     * sp_inp = lambda : map ( int , input ( ).split ( ) )
     * Returns a Stream<Integer> to mimic the map behavior.
     */
    public static java.util.stream.Stream<Integer> sp_inp() {
        if (!scanner.hasNext()) {
            return java.util.stream.Stream.empty();
        }
        
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) {
            return java.util.stream.Stream.empty();
        }
        
        return Arrays.stream(line.split("\\s+"))
                     .map(Integer::parseInt);
    }

    /**
     * str_inp = lambda : input ( )
     */
    public static String str_inp() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }
}