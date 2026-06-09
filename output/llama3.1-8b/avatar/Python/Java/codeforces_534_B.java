import java.util.Scanner;

public class codeforces_534_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        int v1 = Integer.parseInt(input1[0]);
        int v2 = Integer.parseInt(input1[1]);
        int t = Integer.parseInt(input2[0]);
        int d = Integer.parseInt(input2[1]);

        int a = 1;
        int v = v1;
        int distance = 0;

        for (int i = 0; i < t; i++) {
            if (v - v2 > (t - i - 1) * d) {
                a *= -1;
                v = (t - i - 1) * d + v2;
            }
            distance += v;
            v += a * d;
        }

        System.out.println(distance);
    }
}