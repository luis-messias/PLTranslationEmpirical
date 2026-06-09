import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class codeforces_567_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first input (inp) - this line is read but its value is not used in the list creation logic below
        if (scanner.hasNextInt()) {
            int inp = scanner.nextInt();
        } else {
            // Handle case where first input might be missing or invalid, though typically competitive programming assumes valid input structure.
            return;
        }

        // Read the second input to populate the list
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
            if (i == 0) {
                // Python: print(f"{lista[i+1] - lista[i]} {lista[len(lista)-1] - lista[i]}")
                System.out.printf("%d %d%n", lista.get(1) - lista.get(0), lista.get(n - 1) - lista.get(0));
                continue;
            } else if (i == n - 1) {
                // Python: print(f"{lista[len(lista)-1] - lista[len(lista)-2]} {lista[len(lista)-1] - lista[0]}")
                System.out.printf("%d %d%n", lista.get(n - 1) - lista.get(n - 2), lista.get(n - 1) - lista.get(0));
                continue;
            } else {
                // General case
                int diff1 = lista.get(i) - lista.get(i - 1); // lista[i] - lista[i-1]
                int diff2 = lista.get(i + 1) - lista.get(i); // lista[i+1] - lista[i]

                if (diff1 > diff2) {
                    // Python: print(lista[i + 1] - lista[i], end = " ")
                    System.out.print(diff2 + " ");
                } else {
                    // Python: print(lista[i] - lista[i - 1], end = " ")
                    System.out.print(diff1 + " ");
                }

                // Second part of the conditional printing
                // Python: if lista[len(lista) - 1] - lista[i] > lista[i] - lista[0]:
                int diff_end = lista.get(n - 1) - lista.get(i);
                int diff_start = lista.get(i) - lista.get(0);

                if (diff_end > diff_start) {
                    // Python: print(lista[len(lista) - 1] - lista[i])
                    System.out.print(diff_end);
                } else {
                    // Python: print(lista[i] - lista[0])
                    System.out.print(diff_start);
                }
            }
        }
        scanner.close();
    }
}