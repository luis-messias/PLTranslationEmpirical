import java.util.Scanner;

public class s441028271 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read a, b, c, k
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // c is read but not used
        scanner.nextInt(); 
        int k = scanner.nextInt();

        if (k % 2 == 0) {
            System.out.println(a - b);
        } else {
            System.out.println(b - a);
        }
        scanner.close();
    }
}