import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC142_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N (unused in the core logic, but read as per Python)
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();

        // 2. Read the line of space-separated numbers
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String line = scanner.nextLine();
        String[] tokens = line.trim().split("\\s+");

        // 3. Construct list A: (index + 1, value)
        List<Pair> A = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                int value = Integer.parseInt(tokens[i]);
                // i + 1 is the 1-based index
                A.add(new Pair(i + 1, value));
            } catch (NumberFormatException e) {
                // Handle potential parsing errors if input is malformed
                // In a strict translation, we might skip or throw, but here we assume valid input based on Python context.
            }
        }

        // 4. Sort A based on the second element (value)
        // A_ = sorted(A, key=itemgetter(1))
        Collections.sort(A, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.value, p2.value);
            }
        });

        // 5. Extract the first elements (original indices)
        // A__ = [a[0] for a in A_]
        List<Integer> A__ = new ArrayList<>();
        for (Pair p : A) {
            A__.add(p.index);
        }

        // 6. Print all but the last element, followed by a space
        // for i in A__[:-1]: print(i, end=' ')
        for (int i = 0; i < A__.size() - 1; i++) {
            System.out.print(A__.get(i) + " ");
        }

        // 7. Print the last element
        // print(A__[-1])
        if (!A__.isEmpty()) {
            System.out.println(A__.get(A__.size() - 1));
        }

        scanner.close();
    }

    // Helper class to store the pair (index, value)
    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}