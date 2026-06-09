import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_146_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list of numbers
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                numberList.add(scanner.nextInt());
            } else {
                // Handle case where input might be incomplete, though usually not necessary in CP context
                return;
            }
        }

        long h1 = 0;
        long h2 = 0;
        boolean foundInvalid = false;

        for (int i = 0; i < n; i++) {
            int currentNumber = numberList.get(i);

            if (currentNumber != 4 && currentNumber != 7) {
                System.out.println("NO");
                foundInvalid = true;
                break;
            }

            if (i < n / 2) {
                h1 += currentNumber;
            } else {
                h2 += currentNumber;
            }
        }

        if (!foundInvalid) {
            if (h1 == h2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}