import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class s695100304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first input)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the line for x (second input)
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine();

        // Parse x
        String[] tokens = line.split(" ");
        List<Integer> x = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                x.add(Integer.parseInt(token));
            }
        }

        // Reverse x
        Collections.reverse(x);

        // Print *x
        for (int i = 0; i < x.size(); i++) {
            System.out.print(x.get(i) + (i == x.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}
