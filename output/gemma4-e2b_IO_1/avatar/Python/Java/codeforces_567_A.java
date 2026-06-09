import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class codeforces_567_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first input (inp), which is ignored in the list processing logic
        if (scanner.hasNextInt()) {
            // int inp = scanner.nextInt(); // Not strictly needed for the calculation based on the list structure
        }

        // Read the line containing the list elements
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            List<Integer> lista = new ArrayList<>();
            for (String part : parts) {
                if (!part.isEmpty()) {
                    lista.add(Integer.parseInt(part));
                }
            }

            int n = lista.size();

            for (int i = 0; i < n; i++) {
                if (i ==
