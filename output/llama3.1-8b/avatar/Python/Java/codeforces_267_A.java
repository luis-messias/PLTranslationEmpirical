import java.util.Scanner;

public class codeforces_267_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int total = substract(a, b);
            sb.append(total).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int substract(int a, int b) {
        if (a > b) {
            int total = 0;
            while (a > 0 && b > 0) {
                total += (int) Math.floor(a / (double) b);
                a = (int) (a % b);
                if (a > 0) {
                    total += (int) Math.floor(b / (double) a);
                    b = (int) (b % a);
                }
            }
            return total;
        } else if (a < b) {
            int total = 0;
            while (a > 0 && b > 0) {
                total += (int) Math.floor(b / (double) a);
                b = (int) (b % a);
                if (b > 0) {
                    total += (int) Math.floor(a / (double) b);
                    a = (int) (a % b);
                }
            }
            return total;
        } else {
            return 1;
        }
    }
}