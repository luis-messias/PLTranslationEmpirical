import java.util.Scanner;

public class s880494034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        String[] XS = scanner.nextLine().split(" ");

        int m = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            int c = 0;
            for (String x : XS) {
                c += Math.pow(Integer.parseInt(x) - i, 2);
            }
            if (m > c) {
                m = c;
            }
        }

        System.out.println(m);
    }
}