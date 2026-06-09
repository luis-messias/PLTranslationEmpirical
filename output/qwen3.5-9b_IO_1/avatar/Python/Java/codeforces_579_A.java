import java.util.Scanner;

public class codeforces_579_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 1;
        while (n > 0 && (Math.log(n) / Math.log(2) % 1 != 0)) {
            x++;
            n -= (int) Math.pow(2, (int) Math.floor(Math.log(n) / Math.log(2)));
        }
        System.out.println(x);
    }
}
