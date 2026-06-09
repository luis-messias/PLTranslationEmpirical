import java.util.HashMap;
import java.util.Map;

public class atcoder_ABC122_D {
    public static boolean ok(String last4) {
        for (int i = 0; i < 4; i++) {
            char[] t = last4.toCharArray();
            if (i >= 1) {
                char temp = t[i];
                t[i] = t[i - 1];
                t[i - 1] = temp;
            }
            String s = new String(t);
            if (s.contains("AGC")) {
                return false;
            }
        }
        return true;
    }

    public static int dfs(int cur, String last3) {
        Map<String, Integer> memo = getMemo(cur);
        if (memo.containsKey(last3)) {
            return memo.get(last3);
        }
        if (cur == n) {
            return 1;
        }
        int ret = 0;
        for (char c : "ACGT".toCharArray()) {
            String newLast3 = last3 + c;
            if (ok(newLast3)) {
                ret = (ret + dfs(cur + 1, newLast3.substring(1))) % mod;
            }
        }
        memo.put(last3, ret);
        return ret;
    }

    public static Map<String, Integer> getMemo(int n) {
        Map<String, Integer>[] memo = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = new HashMap<>();
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(System.console().readLine());
        int mod = (int) Math.pow(10, 9) + 7;
        Map<String, Integer>[] memo = getMemo(n);
        System.out.println(dfs(0, "TTT"));
    }
}