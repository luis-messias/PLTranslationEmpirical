import java.util.Scanner;

public class s652791025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int n = Integer.parseInt(input.substring(input.length() - 1));

        if (n == 2 || n == 4 || n == 5 || n == 7 || n == 9) {
            System.out.println("hon");
        } else if (n == 0 || n == 1 || n == 6 || n == 8) {
            System.out.println("pon");
        } else {
            System.out.println("bon");
        }
    }
}