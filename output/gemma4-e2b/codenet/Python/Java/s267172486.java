import java.util.Scanner;

public class s267172486 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read h and a from a single line of input
        if (scanner.hasNextInt()) {
            int h = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();

                int ans = h / a;
                int ama = h % a;

                if (ama != 0) {
                    ans += 1;
                }
                System.out.println(ans);
            }
        }
        scanner.close();
    }
}