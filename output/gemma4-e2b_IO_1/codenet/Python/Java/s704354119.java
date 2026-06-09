import java.util.Scanner;

public class s704354119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the line containing the list l
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] l = line.split(" ");

            if (l.length == 0) {
                // Handle case where the line was read but contained no numbers
                return;
            }

            long sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // Iterate through the numbers
            for (String s : l) {
                try {
                    int val = Integer.parseInt(s);
                    sum += val;

                    if (val < min) {
                        min = val;
                    }
                    if (val > max) {
                        max = val;
                    }
                } catch (NumberFormatException e) {
                    // Handle potential non-integer input if necessary, though usually assumed valid in CP context
                }
            }

            // Print the result: min, max, sum
            System.out.println(min + " " + max + " " + sum);
        }

        scanner.close();
    }
}
