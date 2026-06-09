import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC162_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        System.out.println(calculate(n, s));
    }

    public static long calculate(int n, String s) {
        char[] arr = s.toCharArray();
        int rNum = 0;
        int gNum = 0;
        int bNum = 0;
        for (char c : arr) {
            if (c == 'R') rNum++;
            else if (c == 'G') gNum++;
            else if (c == 'B') bNum++;
        }
        long sum = 0;
        for (int step = 1; step <= n / 2; step++) {
            for (int i = 0; i < n - 2 * step; i++) {
                String subStr = s.substring(i, i + step) + s.substring(i + step, i + step * 2);
                if (subStr.equals("RGB") || subStr.equals("RBG") || subStr.equals("BGR") || subStr.equals("BRG")
                        || subStr.equals("GBR") || subStr.equals("GRB")) {
                    sum++;
                }
            }
        }
        return rNum * gNum * bNum - sum;
    }
}