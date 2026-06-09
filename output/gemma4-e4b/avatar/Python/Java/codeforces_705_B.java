import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_705_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (the first line, which is unused in the logic)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the rest of the integers into a list W
        List<Integer> w = new ArrayList<>();
        while (scanner.hasNextInt()) {
            w.add(scanner.nextInt());
        }

        int c = 2;

        for (int i : w) {
            if (i == 1) {
                System.out.println(c);
            } else if (i % 2 == 0) {
                // c = 3 - c
                c = 3 - c;
                System.out.println(c);
            } else {
                // i is odd and i != 1
                System.out.println(c);
            }
        }

        scanner.close();
    }
}