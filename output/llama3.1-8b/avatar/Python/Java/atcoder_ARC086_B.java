import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_ARC086_B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().trim().split(" ");
        int[] a = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        int max_val = 0;
        int max_sign = 0;
        int max_index = -1;
        for (int i = 0; i < N; i++) {
            if (Math.abs(a[i]) > max_val) {
                max_val = Math.abs(a[i]);
                max_sign = mySign(a[i]);
                max_index = i;
            }
        }
        if (max_sign == 0) {
            System.out.println(0);
        } else if (max_sign == 1) {
            System.out.println(2 * N - 1);
            for (int i = 0; i < N; i++) {
                System.out.println(max_index + 1 + " " + (i + 1));
            }
            for (int i = 0; i < N - 1; i++) {
                System.out.println((i + 1) + " " + (i + 2));
            }
        } else {
            System.out.println(2 * N - 1);
            for (int i = 0; i < N; i++) {
                System.out.println(max_index + 1 + " " + (i + 1));
            }
            for (int i = N - 2; i >= 0; i--) {
                System.out.println((i + 1) + " " + (i + 2));
            }
        }
    }

    public static int mySign(int x) {
        return (x > 0) - (x < 0);
    }
}