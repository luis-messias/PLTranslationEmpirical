import java.util.Scanner;

public class s419623944 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int R = Integer.parseInt(parts[1]);

        if (N >= 10) {
            System.out.println(R);
        } else {
            System.out.println(R + 100 * (10 - N));
        }
    }
}