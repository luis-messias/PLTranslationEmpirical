import java.util.Scanner;

public class atcoder_ABC125_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a, b, t from a single line of input
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int t = scanner.nextInt();

            long cookie = 0;
            int time = a;

            // The loop condition involves floating point comparison (t + 0.5)
            // Since time and t are integers, we compare time <= t + 0.5
            while (time <= t + 0.5) {
                cookie += b;
                time += a;
            }

            System.out.println(cookie);
        }
        
        scanner.close();
    }
}