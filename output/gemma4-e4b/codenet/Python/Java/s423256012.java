import java.util.Scanner;

public class s423256012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);

        if ((A + B) % 2 != 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println((A + B) / 2);
        }
        scanner.close();
    }
}