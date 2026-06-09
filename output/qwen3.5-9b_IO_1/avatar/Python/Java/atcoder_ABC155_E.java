import java.util.Scanner;

public class atcoder_ABC155_E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        
        int pp = 0;
        int na = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int cc = na + (c - '0');
            na = 0;
            if (cc <= 4) {
                pp += cc;
            } else {
                na = 1;
                if (i == s.length() - 1) {
                    pp += 1;
                }
                pp += 10 - cc;
            }
        }
        
        int pmin = 1000;
        int mmin = 0;
        String s2 = "0" + s;
        for (int i = s2.length() - 1; i >= 0; i--) {
            char c = s2.charAt(i);
            int v = c - '0';
            int npmin = Math.min(pmin + 10 - (v + 1), mmin + 10 - v);
            int nmmin = Math.min(pmin + v + 1, mmin + v);
            pmin = npmin;
            mmin = nmmin;
        }
        
        System.out.println(Math.min(pmin, mmin));
    }
}
