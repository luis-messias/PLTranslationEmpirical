import java.util.Scanner;

public class s453478465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if (a <= 8 && b <= 8) {
            System.out.println("Yay!");
        } else {
            System.out.println(":(");
        }
    }
}