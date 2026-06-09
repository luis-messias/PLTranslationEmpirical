import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s621701371 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read s
        String s = scanner.nextLine();

        // 2. Read q
        int q = Integer.parseInt(scanner.nextLine());

        // 3. Read qs
        List<String[]> qs = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            qs.add(parts);
        }

        boolean n = false;
        String left = "";
        String right = "";

        for (String[] operation : qs) {
            String opType = operation[0];
            if (opType.equals("1")) {
                n = !n;
            } else if (opType.equals("2")) {
                // t is unused, f and c are the other two elements
                String fStr = operation[1];
                String c = operation[2];
                int f = Integer.parseInt(fStr);

                if (n) {
                    // f = 1 if f != 1 else 2
                    if (f == 1) {
                        f = 2;
                    } else {
                        f = 1;
                    }
                }

                if (f == 1) {
                    left = c + left;
                } else if (f == 2) {
                    right = right + c;
                }
            }
        }

        // s = left + s + right
        String sCombined = left + s + right;

        // print(s[::-1] if n else s)
        if (n) {
            // Reverse sCombined
            String reversedS = new StringBuilder(sCombined).reverse().toString();
            System.out.println(reversedS);
        } else {
            System.out.println(sCombined);
        }
        
        scanner.close();
    }
}