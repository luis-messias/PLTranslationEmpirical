import java.util.Scanner;

public class codeforces_581_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two space-separated integers
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // Calculate min(a, b)
            int minVal = Math.min(a, b);

            // Calculate max(a, b)
            int maxVal = Math.max(a, b);

            // Calculate (max - min) // 2
            int result2 = (maxVal - minVal) / 2;

            // Print the two results separated by a space
            System.out.println(minVal + " " + result2);
        }
        scanner.close();
    }
}