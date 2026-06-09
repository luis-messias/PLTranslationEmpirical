import java.util.Scanner;

public class s557080041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();

        if (N.equals("0")) {
            System.out.println("Yes");
        } else {
            int sum = 0;
            for (int i = 0; i < N.length(); i++) {
                // Convert character digit to integer value
                sum += N.charAt(i) - '0';
            }

            if (sum % 9 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
