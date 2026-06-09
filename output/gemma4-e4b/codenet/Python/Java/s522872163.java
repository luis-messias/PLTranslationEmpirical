import java.util.Scanner;

public class s522872163 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int X = Integer.parseInt(parts[0]);
        int A = Integer.parseInt(parts[1]);

        if (X < A) {
            System.out.println(0);
        } else {
            System.out.println(10);
        }
        scanner.close();
    }
}