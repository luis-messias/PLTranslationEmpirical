import java.util.Scanner;

public class s013976107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        String B = scanner.next();
        String S = scanner.next();

        if (S.charAt(A) == '-' && S.replace("-", "").length == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}