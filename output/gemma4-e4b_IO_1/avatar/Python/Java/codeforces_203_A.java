import java.util.Scanner;
import java.lang.Math;

public class codeforces_203_A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the 6 inputs: x, t, a, b, da, db
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int x = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int da = scanner.nextInt();
        int db = scanner.nextInt();
        
        scanner.close();

        // Handle the x == 0 case
        if (x == 0) {
            System.out.println("YES");
            return;
        }

        // Calculate a_time and b_time
        // a_time = min(a / da, t - 1)
        int a_time = Math.min(a / da, t - 1);
        // b_time = min(b / db, t - 1)
        int b_time = Math.min(b / db, t - 1);

        boolean found = false;
        
        // Iterate through all combinations
        for (int i = 0; i <= a_time; i++) {
            for (int j = 0; j <= b_time; j++) {
                // Condition
