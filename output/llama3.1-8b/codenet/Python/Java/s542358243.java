import java.util.Scanner;

public class s542358243 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        if (N % 9 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}