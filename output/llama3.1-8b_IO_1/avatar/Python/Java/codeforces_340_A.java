import java.util.Scanner;

public class codeforces_340_A {
    public static int G(int a, int b) {
        while (a % b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return b;
    }

    public static int L(int a, int b) {
        return (a * b) / G(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] l = input.split(" ");
        int x = Integer.parseInt(l[0]);
        int y = Integer.parseInt(l[1]);
        int a = Integer.parseInt(l[2]);
        int b = Integer.parseInt(l[3]);
        int lcm = L(x, y);
        System.out.println((b / (double)lcm) - ((a - 1) / (double)lcm));
    }
}
