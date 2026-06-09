import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC123_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read x, y, z, k
        // The Python code reads x, y, z, k from a single line.
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        if (parts1.length < 4) return;
        
        int x = Integer.parseInt(parts1[0]);
        int y = Integer.parseInt(parts1[1]);
        int z = Integer.parseInt(parts1[2]);
        int k = Integer.parseInt(parts1[3]);

        // Read a
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        List<Integer> a = new ArrayList<>();
        for (String part : parts2) {
            a.add(Integer.parseInt(part));
        }

        // Read b
        if (!scanner.hasNextLine()) return;
        String line3 = scanner.nextLine();
        String[] parts3 = line3.split(" ");
        List<Integer> b = new ArrayList<>();
        for (String part : parts3) {
            b.add(Integer.parseInt(part));
        }

        // Read c
        if (!scanner.hasNextLine()) return;
        String line4 = scanner.nextLine();
        String[] parts4 = line4.split(" ");
        List<Integer> c = new ArrayList<>();
        for (String part : parts4) {
            c.add(Integer.parseInt(part));
        }

        // Calculate ab
        List<Integer> ab = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ab.add(a.get(i) + b.get(j));
            }
        }

        // Sort ab in reverse order
        Collections.sort(ab, Collections.reverseOrder());

        // Calculate abc
        List<Integer> abc = new ArrayList<>();
        int limit = Math.min(k, x * y);
        
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < z; j++) {
                // ab[i] + c[j]
                abc.add(ab.get(i) + c.get(j));
            }
        }

        // Sort abc in reverse order
        Collections.sort(abc, Collections.reverseOrder());

        // Print results
        for (int i = 0; i < k; i++) {
            // Ensure we don't go out of bounds if abc size is smaller than k, 
            // although based on the loop structure, abc.size() should be at least limit.
            if (i < abc.size()) {
                System.out.println(abc.get(i));
            }
        }

        scanner.close();
    }
}