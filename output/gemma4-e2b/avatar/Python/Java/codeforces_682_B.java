import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_682_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n = IN() - Read the first integer (n)
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or invalid for n
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        // l = I() - Read the next line for the list l
        List<Integer> l = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        l.add(Integer.parseInt(part));
                    } catch (NumberFormatException e) {
                        // Ignore non-integer parts if any, though input implies integers
                    }
                }
            }
        }
        
        // If the input reading logic in Python was strictly sequential reading of tokens, 
        // we might need to adjust how we read the list l if it was on the same line as n, 
        // but based on the lambda definitions, n is read first, then l is read next.
        // We rely on the standard behavior of reading subsequent lines.

        // f = 1 (not used in the final calculation, but initialized)
        // f = 1; 

        // l.sort()
        Collections.sort(l);

        // c = 0
        int c = 0;

        // for i in l: if i > c: c += 1
        for (int i : l) {
            if (i > c) {
                c++;
            }
        }

        // print(c + 1)
        System.out.println(c + 1);

        scanner.close();
    }
}