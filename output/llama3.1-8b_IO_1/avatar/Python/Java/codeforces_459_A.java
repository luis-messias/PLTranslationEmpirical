import java.util.Scanner;
import java.lang.Math;

public class codeforces_459_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String given = scanner.nextLine();
        String[] l1 = given.split(" ");
        int x1 = Integer.parseInt(l1[0]);
        int y1 = Integer.parseInt(l1[1]);
        int x2 = Integer.parseInt(l1[2]);
        int y2 = Integer.parseInt(l1[3]);

        if (x2 == x1) {
            int d = (int) Math.sqrt(Math.pow(y2 - y1, 2));
            System.out.println(x1 + " " + (y1 + d) + " " + x2 + " " + (y2 + d));
        } else if (y2 == y1) {
            int d = (int) Math.sqrt(Math.pow(x2 - x1, 2));
            System.out.println((x1 + d) + " " + y1 + " " + (x2 + d) + " " + y2);
        } else if ((y2 - y1) / (x2 - x1) == 1) {
            int x3 = x2;
            int y3 = y2;
            int x4 = x1;
            int y4 = y1;
            System.out.println(x3 + " " + y3 + " " + x4 + " " + y4);
        } else if ((y2 - y1) / (x2 - x1) == -1) {
            int x3 = x2;
            int y3 = y1;
            int x4 = x1;
            int y4 = y2;
            System.out.println(x3 + " " + y3 + " " + x4 + " " + y4);
        } else {
            System.out.println("-1");
        }
    }
}
