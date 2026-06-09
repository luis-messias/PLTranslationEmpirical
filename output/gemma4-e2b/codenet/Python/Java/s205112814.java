import java.util.Scanner;

public class s205112814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Initialize tracking variables based on the Python logic
        // max_under_th = max([l[0] for l in gate_cond])
        int maxUnderTh = Integer.MIN_VALUE;
        // min_upper_th = min([l[1] for l in gate_cond])
        int minUpperTh = Integer.MAX_VALUE;

        // Read m pairs of numbers (assuming input provides m lines of pairs)
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) break;
            int x = scanner.nextInt(); // Corresponds to l[0]
            if (!scanner.hasNextInt()) break;
            int y = scanner.nextInt(); // Corresponds to l[1]

            // Update max_under_th
            if (x > maxUnderTh) {
                maxUnderTh = x;
            }
            // Update min_upper_th
            if (y < minUpperTh) {
                minUpperTh = y;
            }
        }

        // Calculate result based on the condition
        if (minUpperTh - maxUnderTh >= 0) {
            System.out.println(minUpperTh - maxUnderTh + 1);
        } else {
            System.out