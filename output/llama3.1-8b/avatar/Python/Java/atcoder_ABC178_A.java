import java.util.Scanner;

public class atcoder_ABC178_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    public static void solve(Scanner scanner) {
        int a = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(a == 0 ? "1" : "0");
    }
}