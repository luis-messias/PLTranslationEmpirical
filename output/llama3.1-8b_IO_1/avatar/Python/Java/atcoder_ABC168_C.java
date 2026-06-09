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

        double C = Math.toDegrees(Math.acos((a*a + b*b - Math.pow(12*h+Math.floor(m/60.0), 2))/(2*a*b)));
        if (C < 0) {
            C += 360;
        }
        System.out.println(Math.sqrt(a*a + b*b - 2*a*b*Math.cos(Math.toRadians(C))));
    }
}
