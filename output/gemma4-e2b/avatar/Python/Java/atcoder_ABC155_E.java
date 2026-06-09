import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC155_E {

    // The logic from main_b is not directly used in the final return value of main,
    // but we include the structure for completeness if it were called.
    // Since the core logic is in main, we focus there.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input string s (equivalent to input() in Python)
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String s = scanner.nextLine();

        // The logic from main()
        long pmin = 1000;
        long mmin = 0;

        // s = '0' + s
        String s_padded = "0" + s;

        // Iterate over the string in reverse
        for (int i = s_padded.length() - 1; i >= 0; i--) {
            char c = s_padded.charAt(i);
            int v = Character.getNumericValue(c);

            // npmin = min( pmin + 10 - (v + 1), mmin + 10 - v )
            long npmin = Math.min(pmin + 10 - (v + 1), mmin + 10 - v);

            // nmmin = min( pmin + v + 1, mmin + v )
            long nmmin = Math.min(pmin + v + 1, mmin + v);

            pmin = npmin;
            mmin = nmmin;
        }

        // return min(pmin, mmin)
        long result = Math.min(pmin, mmin);

        System.out.println(result);

        scanner.close();
    }
}