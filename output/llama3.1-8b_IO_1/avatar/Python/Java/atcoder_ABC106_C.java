import java.util.*;
import java.io.*;

public class atcoder_ABC106_C {
    static long inf = (long) 1e20;
    static double eps = 1.0 / (double) 1e10;
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c != '1') break;
            l++;
        }
        if (l >= k) System.out.println(1);
        else System.out.println(s.charAt(l));
    }

    static String LI() throws IOException {
        return br.readLine();
    }

    static int I() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static double F() throws IOException {
        return Double.parseDouble(br.readLine());
    }
}
