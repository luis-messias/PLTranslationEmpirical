import java.util.*;

public class atcoder_ABC122_D {
    static int n;
    static long mod = 1000000007;
    static Map<Integer, Map<String, Long>> memo;
    
    static boolean ok(String last4) {
        char[] t = last4.toCharArray();
        for (int i = 0; i < 4; i++) {
            if (i >= 1) {
                char[] temp = t.clone();
                temp[i] = t[i - 1];
                temp[i - 1] = t[i];
                String swapped = new String(temp);
                if (swapped.contains("AGC")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static long dfs(int cur, String last3) {
        if (memo.containsKey(cur)) {
            return memo.get(cur).getOrDefault(last3, 0);
        }
        
        if (cur == n) {
            return 1;
        }
        
        long ret = 0;
        for (char c : "ACGT".toCharArray()) {
            String newLast3 = last3.substring(1) + c;
            if (ok(last3.substring(0, 3) + c)) {
                ret = (ret + dfs(cur + 1, newLast3)) % mod;
            }
        }
        
        memo.put(cur, new HashMap<>());
        memo.get(cur).put(last3, ret);
        return ret;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        memo = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            memo.put(i, new HashMap<>());
        }
        System.out.println(dfs(0, "TTT"));
    }
}
