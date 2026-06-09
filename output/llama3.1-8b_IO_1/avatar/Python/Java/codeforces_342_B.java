import java.util.Scanner;

public class codeforces_342_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        int f = Integer.parseInt(input[3]);

        if (s < f) {
            int d = 1;
            char c = 'R';
        } else {
            int d = -1;
            char c = 'L';
        }

        String res = "";
        int i = 1, j = s;

        while (j != f) {
            input = scanner.nextLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);

            if (i > t && m < k) {
                input = scanner.nextLine().split(" ");
                t = Integer.parseInt(input[0]);
                l = Integer.parseInt(input[1]);
                r = Integer.parseInt(input[2]);
                k++;
            }

            if (i == t && (l <= j && j <= r || l <= j + d && j + d <= r)) {
                res += "X";
            } else {
                res += String.valueOf(c);
                j += d;
            }
            i++;
        }
        System.out.println(res);
    }
}
