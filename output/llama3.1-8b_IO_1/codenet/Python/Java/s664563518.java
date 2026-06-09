import java.util.*;
import java.io.*;

public class s664563518 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N];
        int[] t = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = st.nextToken();
            t[i] = Integer.parseInt(st.nextToken());
        }

        String X = br.readLine();

        int xi = -1;

        for (int i = 0; i < N; i++) {
            if (s[i].equals(X)) {
                xi = i;
                break;
            }
        }

        long ans = 0;

        for (int i = 0; i < N; i++) {
            if (xi < i) {
                ans += t[i];
            }
        }

        System.out.println(ans);
    }
}
