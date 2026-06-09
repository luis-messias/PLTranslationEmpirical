import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeforces_350_B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tStr = br.readLine().split(" ");
        String[] aStr = br.readLine().split(" ");

        int[] t = new int[n + 1];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(tStr[i]);
        }
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }

        int[] cnt = new int[n + 1];

        for (int i : a) {
            cnt[i]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (t[i] == 1) {
                List<Integer> crt = new ArrayList<>();
                int x = a[i];
                while (cnt[x] == 1) {
                    crt.add(x);
                    x = a[x];
                }
                if (crt.size() > ans.size()) {
                    ans.clear();
                    ans.addAll(crt);
                }
            }
        }

        Collections.reverse(ans);
        System.out.println(ans.size());
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
