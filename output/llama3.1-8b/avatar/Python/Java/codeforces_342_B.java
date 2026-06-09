import java.util.Scanner;
import java.util.Arrays;

public class codeforces_342_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0], m = arr[1], s = arr[2], f = arr[3];
        String res = "";
        int i = 1, j = s;
        if (s < f) {
            int d = 1;
            char c = 'R';
        } else {
            int d = -1;
            char c = 'L';
        }
        while (j != f) {
            int[] tlr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i > tlr[0] && m < 2) {
                m++;
            }
            if (i == tlr[0] && (tlr[1] <= j && j <= tlr[2] || tlr[1] <= j + d && j + d <= tlr[2])) {
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