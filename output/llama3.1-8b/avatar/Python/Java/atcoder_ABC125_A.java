import java.util.Scanner;

public class atcoder_ABC125_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        double t = Double.parseDouble(input[2]);

        int cookie = 0;
        double time = a;

        while (time <= t + 0.5) {
            cookie += b;
            time += a;
        }

        System.out.println(cookie);
    }
}