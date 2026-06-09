import java.util.Arrays;
import java.util.Scanner;

public class codeforces_369_B {
    public static int[] getNums(int num, int t) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            if (i >= t % num) {
                result[i] = t / num + 1;
            } else {
                result[i] = t / num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k, l, r, sa, sk;
        String[] input = scanner.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        l = Integer.parseInt(input[2]);
        r = Integer.parseInt(input[3]);
        sa = Integer.parseInt(input[4]);
        sk = Integer.parseInt(input[5]);

        int[] ans1 = getNums(k, sk);
        int[] ans2 = getNums(n - k, sa - sk);

        for (int i = 0; i < ans1.length + ans2.length; i++) {
            if (i < ans1.length) {
                System.out.print(ans1[i]);
            }
            if (i < ans2.length) {
                System.out.print(" " + ans2[i]);
            }
        }
    }
}