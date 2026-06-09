import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeforces_242_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int id = 0;
        String[] input1 = br.readLine().split(" ");
        int l = Integer.parseInt(input1[0]);
        int r = Integer.parseInt(input1[1]);

        for (int i = 1; i <= n; i++) {
            String[] input2 = br.readLine().split(" ");
            int li = Integer.parseInt(input2[0]);
            int ri = Integer.parseInt(input2[1]);
            if (li <= l && r <= ri) id = i;
            else if (li < l || r < ri) id = n;
            l = Math.min(l, li);
            r = Math.max(r, ri);
        }
        System.out.println(id == n ? -1 : i + 1);
    }
}
