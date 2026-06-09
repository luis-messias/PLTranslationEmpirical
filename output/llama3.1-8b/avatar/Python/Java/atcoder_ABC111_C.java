import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC111_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] xStr = scanner.nextLine().split(" ");
        int[] x = new int[xStr.length];
        for (int i = 0; i < xStr.length; i++) {
            x[i] = Integer.parseInt(xStr[i]);
        }
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        int idxA = 0;
        int idxB = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[idxA++] = x[i];
            } else {
                b[idxB++] = x[i];
            }
        }
        int[] cnta = new int[100002 + 1];
        int[] cntb = new int[100002 + 1];
        Arrays.fill(cnta, 0);
        Arrays.fill(cntb, 0);
        int vala = 0;
        int maxCnta = 0;
        int vala1 = 0;
        int maxCnta1 = 0;
        for (int i : a) {
            cnta[i]++;
        }
        for (int i : a) {
            if (maxCnta < cnta[i]) {
                vala = i;
                maxCnta = cnta[i];
            }
        }
        for (int i : a) {
            if (maxCnta1 < cnta[i] && vala != i) {
                maxCnta1 = cnta[i];
                vala1 = i;
            }
        }
        int valb = 0;
        int maxCntb = 0;
        int valb1 = 0;
        int maxCntb1 = 0;
        for (int i : b) {
            cntb[i]++;
        }
        for (int i : b) {
            if (maxCntb < cntb[i]) {
                valb = i;
                maxCntb = cntb[i];
            }
        }
        for (int i : b) {
            if (maxCntb1 < cntb[i] && valb != i) {
                maxCntb1 = cntb[i];
                valb1 = i;
            }
        }
        if (vala != valb) {
            int res = 0;
            for (int i : a) {
                if (i != vala) {
                    res++;
                }
            }
            for (int i : b) {
                if (i != valb) {
                    res++;
                }
            }
            System.out.println(res);
        } else {
            int resa = 0;
            int resb = 0;
            int resa1 = 0;
            int resb1 = 0;
            for (int i : a) {
                if (i != vala) {
                    resa++;
                }
                if (i != vala1) {
                    resa1++;
                }
            }
            for (int i : b) {
                if (i != valb) {
                    resb++;
                }
                if (i != valb1) {
                    resb1++;
                }
            }
            System.out.println(Math.min(resa + resb1, resa1 + resb));
        }
    }
}