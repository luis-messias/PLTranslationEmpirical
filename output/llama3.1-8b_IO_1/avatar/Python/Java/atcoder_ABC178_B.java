import java.util.*;
import java.io.*;

public class atcoder_ABC178_B {
    static final int MOD = 1000000007;
    static final long INF = 2000000000000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(a * c, Math.max(b * d, Math.max(a * d, b * c))));
    }
}
