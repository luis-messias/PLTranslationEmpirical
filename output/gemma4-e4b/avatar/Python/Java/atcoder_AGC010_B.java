import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class atcoder_AGC010_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        long n = scanner.nextInt();

        // Read array A
        List<Long> a = new ArrayList<>();
        while (scanner.hasNextInt()) {
            a.add((long) scanner.nextInt());
        }
        scanner.close();

        // Calculate sum(a)
        long sumA = 0;
        for (long val : a) {
            sumA += val;
        }

        // Calculate D = n * (n + 1) / 2
        // Since n is long, n*(n+1) might overflow standard int, use long.
        long divisor = n * (n + 1) / 2;

        // Initial check: sum(a) % D
        if (sumA % divisor != 0) {
            System.out.println("NO");
            return;
        }

        // Calculate k = sum(a) / D
        long k = sumA / divisor;

        // Modify a: a += [ a[0] ]
        // We must use a mutable list/array for the calculation.
        List<Long> modifiedA = new ArrayList<>(a);
        if (!modifiedA.isEmpty()) {
            modifiedA.add(modifiedA.get(0));
        }

        // The length of the original array was N. The modified array length is N+1.
        // The loop runs N times, corresponding to the length of a[1:] (which is N).
        int loopLength = a.size();

        // Calculate the two sums based on the zip operation:
        // Pairs (i, j)