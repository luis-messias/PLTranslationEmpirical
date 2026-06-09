import java.util.Scanner;

public class atcoder_AGC037_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        String S = scanner.nextLine();
        boolean aaaa = false;
        if (K >= 15) {
            aaaa = true;
        } else if ((int) Math.pow(2, K) >= N) {
            aaaa = true;
        }
        if (aaaa) {
            System.out.println(S.charAt(0) * N);
            return;
        }

        String U = S + new StringBuilder(S).reverse().toString();
        char c = S.charAt(0);
        int p = U.indexOf(c);
        int minindex = p;
        p++;
        while (p <= N) {
            if (U.charAt(p) == c) {
                if (checkNormalDict(U, minindex, p)) {
                    minindex = p;
                }
            }
            p++;
        }
        String lastDict = U.substring(minindex, minindex + N);
        if (K == 1) {
            System.out.println(lastDict);
        } else {
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == S.charAt(0)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count * (int) Math.pow(2, K - 1) >= N) {
                System.out.println(S.charAt(0) + "" + N);
            } else {
                String newS = S.charAt(0) + "";
                for (int i = 0; i < count * ((int) Math.pow(2, K - 1) - 1); i++) {
                    newS += S.charAt(0);
                }
                System.out.println(newS + lastDict.substring(0, N));
            }
        }
    }

    public static boolean checkNormalDict(String u, int pointer1, int pointer2) {
        for (int i = 0; i < N; i++) {
            if (u.charAt(pointer1 + i) > u.charAt(pointer2 + i)) {
                return true;
            } else if (u.charAt(pointer1 + i) < u.charAt(pointer2 + i)) {
                return false;
            }
        }
        return false;
    }
}
