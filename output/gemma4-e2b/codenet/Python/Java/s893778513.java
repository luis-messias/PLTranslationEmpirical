import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s893778513 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (ignored)
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // Read the list l
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            
            List<Integer> l = new ArrayList<>();
            for (String part : parts) {
                if (!part.isEmpty()) {
                    l.add(Integer.parseInt(part));
                }
            }

            if (!l.isEmpty()) {
                // b = max(l)
                int b = Collections.max(l);
                
                // s = sum(l)
                long s = 0;
                for (int x : l) {
                    s += x;
                }

                // if b < s - b:
                if (b < s - b) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        scanner.close();
    }
}