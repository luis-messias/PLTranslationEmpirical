import java.util.Scanner;

public class codeforces_23_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(scanner.nextLine());
            if (a < 2) {
                System.out.println(0);
            } else {
                System.out.println(a - 2);
            }
        }
    }
}