import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class codeforces_299_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The Python code implies reading input, processing it, and printing a result.
        // We simulate reading a single line of space-separated integers.
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            // Parse the input into an array of integers
            String[] parts = line.split("\\s+");
            int[] a = new int[parts.length];
            
            for (int i = 0; i < parts.length; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }

            // Equivalent to: a = sorted(map(int, [ * open(0) ] [1].split( ) ))
            Arrays.sort(a);

            // The Python expression: print([a[0], -1][any(x % a[0] for x in a)])
            // Since a is sorted, a[0] is the smallest element.
            // The condition any(x % a[0] for x in a) is always true if a is non-empty (because a[0] % a[0] == 0).
            // The result is [a[0], -1][true], which is a[0].
            
            if (a.length > 0) {
                // The result is a[0]
                System.out.println(a[0]);
            }
        }
        scanner.close();
    }
}