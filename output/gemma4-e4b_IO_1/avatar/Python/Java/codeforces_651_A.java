import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class codeforces_651_A {

    // Global scanner instance for input handling
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Handle the initial input and calculation (mimicking the first two lines of Python)
        // The input is expected to be two space-separated integers.
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Python uses mathematical modulo (result sign matches divisor).
            // Java's % is the remainder operator (result sign matches dividend).
            // We calculate (y - x) mod 3 using the formula: ((A % N) + N) % N
            int diff = y - x;
            int N = 3;
            
            // Calculate (y - x) % 3 mathematically
            int modulo_result = ((diff % N) + N) % N;

            // Python: ( ( y - x ) % 3 > 0 ) evaluates to 1 if true, 0 if false.
            int condition = (modulo_result > 0) ? 1 : 0;

            // Calculate max(x + y - 3 + condition, 0)
            int result = Math.max(x + y - 3 + condition, 0);
            System.out.println(result);
        }

        // 2. Define utility methods (mimicking the lambda functions)
        // Note: These methods are kept for structural completeness but are not required for the main calculation.
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
                     .collect(Collectors.toList());
    }

    /**
     * sp_inp = lambda : map ( int , input ( ).split ( ) )
     * Returns a Stream<Integer> to mimic the map behavior.
     */
    public static Stream<Integer> sp_inp() {
        if (!scanner.hasNext()) {
            return Stream.empty();
        }
        
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) {
            return Stream.empty();
        }
        
        return Arrays.stream(line.split("\\s+"))
                     .map(Integer::parseInt);
    }

    /**
