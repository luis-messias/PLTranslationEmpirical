import java.util.Scanner;

public class atcoder_AGC037_E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();
        
        boolean aaaa = false;
        if (K >= 15) {
            aaaa = true;
        } else if ((long)Math.pow(2, K) >= N) {
            aaaa = true;
        }
        
        if (aaaa) {
            System.out.println(minChar(S) * N);
            return;
        }
        
        String S2 = get_last_dict(S);
        
        if (K == 1) {
            System.out.println(S2);
        } else {
            int count = 0;
            for (int i = 0; i < S2.length(); i++) {
                if (S2.charAt(i) == S2.charAt(0)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count * (1 << (K - 1)) >= N) {
                System.out.println(S2.charAt(0) * N);
            } else {
                String temp = S2.substring(0, count * ((1 << (K - 1)) - 1));
                String finalS = temp + S2;
                System.out.println(finalS.substring(0, N));
            }
        }
    }
    
    private static String get_last_dict(String s_str) {
        String U = s_str + s_str;
        char c = s_str.charAt(0);
        int p = U.indexOf(c);
        int minindex = p;
        p++;
        while (p <= s_str.length() * 2) {
            if (U.charAt(p - 1) == c) {
                if (check_normal_dict(U, minindex, p - 1)) {
                    minindex = p - 1;
                }
            }
            p++;
        }
        return U.substring(minindex, minindex + s_str.length());
    }
    
    private static boolean check_normal_dict(String u, int pointer1, int pointer2) {
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(pointer1 + i) > u.charAt(pointer2 + i)) {
                return true;
            } else if (u.charAt(pointer1 + i) < u.charAt(pointer2 + i)) {
                return false;
            }
        }
        return false;
    }
    
    private static char minChar(String s) {
        char min = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < min) {
                min = s.charAt(i);
            }
        }
        return min;
    }
}
