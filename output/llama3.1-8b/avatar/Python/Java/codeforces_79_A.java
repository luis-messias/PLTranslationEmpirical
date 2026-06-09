import java.util.Scanner;

public class codeforces_79_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        boolean a = false;
        while (x >= 0 && y >= 22 || x >= 1 && y >= 12 || x >= 2 && y >= 2) {
            if (a) {
                if (y >= 22) {
                    y -= 22;
                } else if (x >= 1 && y >= 12) {
                    x--;
                    y -= 12;
                } else {
                    x -= 2;
                    y -= 2;
                }
            } else {
                if (x >= 2 && y >= 2) {
                    x -= 2;
                    y -= 2;
                } else if (x >= 1 && y >= 12) {
                    x--;
                    y -= 12;
                } else {
                    y -= 22;
                }
            }
            a = !a;
        }

        System.out.println(a ? "Hanako" : "Ciel");
    }
}