import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class atcoder_AGC006_B {

    // Helper function to calculate the median of three numbers
    private static int median(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        return arr[1];
    }

    /**
     * Implements the 'sub' reduction process.
     * y is modified iteratively until length is 1.
     * @param y The initial list of integers.
     * @param debug If true, prints intermediate steps.
     * @return The final single element list.
     */
    private static ArrayList<Integer> sub(ArrayList<Integer> y, boolean debug) {
        if (debug) {
            System.out.println("D " + y);
        }
        
        while (y.size() > 1) {
            ArrayList<Integer> nextY = new ArrayList<>();
            for (int i = 0; i <= y.size() - 3; i++) {
                int a = y.get(i);
                int b = y.get(i + 1);
                int c = y.get(i + 2);
                nextY.add(median(a, b, c));
            }
            y = nextY;
            if (debug) {
                System.out.println("D " + y);
            }
        }
        return y;
    }

    /**
     * Implements the logic of the Python function calc(x).
     * @param x The initial list.
     * @return The first element of the reduced list.
     */
    private static int calc(ArrayList<Integer> x) {
        // y = sub(x)
        ArrayList<Integer> y = sub(new ArrayList<>(x), false);
        
        // Check if y[0] == 2
        if (!y.isEmpty() && y.get(0) == 2) {
            // pass
            // sub(x, 1) -> debug=true
            sub(new ArrayList<>(x), true);
            // print("=", x)
            System.out.print("=" + x);
        }
        
        // return y[0]
        return y.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and X
        if (!scanner.hasNextInt()) {
            //
