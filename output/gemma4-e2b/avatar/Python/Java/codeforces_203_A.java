import java.util.Scanner;
import java.lang.Math;

public class codeforces_203_A {
    public static String main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line
        if (!scanner.hasNextLine()) {
            return ""; // Handle empty input case if necessary
        }
        String line = scanner.nextLine();
        String[] xxs = line.split(" ");

        if (xxs.length < 6) {
            // Handle case where not enough numbers are provided, though usually assumed correct in competitive programming context
            return "Error: Insufficient input";
        }

        // Parse the integers
        int x = Integer.parseInt(xxs[0]);
        int t = Integer.parseInt(xxs[1]);
        int a = Integer.parseInt(xxs[2]);
        int b = Integer.parseInt(xxs[3]);
        int da = Integer.parseInt(xxs[4]);
        int db = Integer.parseInt(xxs[5]);

        // Equivalent to the Python function main()
        String result = mainLogic(x, t, a, b, da, db);

        // Equivalent to the final check
        if (result.equals("Result Not Found")) {
            System.out.println("NO");
        }
        
        return result;
    }

    public static String mainLogic(int x, int t, int a, int b, int da, int db) {
        if (x == 0) {
            System.out.println("YES");
            return "Result Found";
        }

        // a_time = min([ a // da , t - 1 ])
        int a_time = Math.min(a / da, t - 1);
        
        // b_time = min([ b // db , t - 1 ])
        int b_time = Math.min(b / db, t - 1);

        for (int i = 0; i <= a_time; i++) {
            for (int j = 0; j <= b_time; j++) {
                int val_a = a - da * i;
                int val_b = b - db * j;

                // Check condition 1: a - da * i == x or b - db * j == x
                if (val_a == x || val_b == x) {
                    System.out.println("YES");
                    return "Result Found";
                }

                // Check condition 2: (a - da * i) + (b - db * j) == x
                if (val_a + val_b == x) {
                    System.out.println("YES");
                    return "Result Found";
                }
            }
        }

        return "Result Not Found";
    }
}