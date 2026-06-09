import java.util.Scanner;

public class s441028271 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        int k = Integer.parseInt(parts[3]);

        if (k % 2 == 0) {
            System.out.println(a - b);
        } else {
            System.out.println(b - a);
        }
        scanner.close();
    }
}