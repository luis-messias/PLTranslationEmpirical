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
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int l = Integer.parseInt(input[2]);
        int r = Integer.parseInt(input[3]);
        int sa = Integer.parseInt(input[4]);
        int sk = Integer.parseInt(input[5]);

        int[] ans1 = getNums(k, sk);
        int[] ans2 = getNums(n - k, sa - sk);

        for (int i = 0; i < Math.max(ans1.length, ans2.length); i++) {
            if (i < ans1.length) {
                System.out.print(ans1[i] + " ");
            }
            if (i < ans2.length) {
                System.out.print(ans2[i] + " ");
            }
        }
    }
}
