import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC168_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);
        int m = Integer.parseInt(input[3]);

        double C = Math.abs((360.0 / 60 * m) - (360.0 / 12 * h) - (360.0 / 1440 * m));
        if (C > 180) {
            C = 360 - C;
        }
        double cosC = Math.cos(Math.toRadians(C));

        System.out.println(Math.sqrt(a*a + b*b - 2*a*b*cosC));
    }
}