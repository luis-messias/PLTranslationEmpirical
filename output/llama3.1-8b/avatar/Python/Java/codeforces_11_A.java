import java.util.Scanner;

public class codeforces_11_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        String[] xStr = scanner.nextLine().split(" ");
        int[] x = new int[xStr.length];
        for (int i = 0; i < xStr.length; i++) {
            x[i] = Integer.parseInt(xStr[i]);
        }

        int m = 0;
        for (int a = 0; a < x.length - 1; a++) {
            if (x[a] >= x[a + 1]) {
                int q = (x[a] - x[a + 1]) / d + 1;
                m += q;
                x[a + 1] += q * d;
            }
        }

        System.out.println(m);
    }
}