import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_421_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n, a, b (We only need n for the loop bound)
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        
        int n = 0;
        if (parts1.length >= 1) {
            n = Integer.parseInt(parts1[0]);
        }

        // Read lista
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        List<Integer> lista = new ArrayList<>();
        for (String s : parts2) {
            if (!s.isEmpty()) {
                lista.add(Integer.parseInt(s));
            }
        }

        // Read listb (Read to consume input, though unused)
        if (!scanner.hasNextLine()) return;
        scanner.nextLine(); // Consume the line for listb

        // Logic: Iterate k from 0 to n-1
        for (int k = 0; k < n; k++) {
            // Check if k + 1 is in lista
            if (lista.contains(k + 1)) {
                System.out.print(1, " ");
            } else {
                System.out.print(2, " ");
            }
        }
        System.out.println();
    }
}
