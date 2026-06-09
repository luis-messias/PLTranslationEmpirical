import java.util.Scanner;

public class s000375264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);

        if (X > t) {
            System.out.println(X - t);
        } else {
            System.out.println(0);
        }
    }
}