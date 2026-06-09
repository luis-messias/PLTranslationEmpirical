import java.util.*;
public class atcoder_ABC140_F {
    public static int I() throws Exception { return Integer.parseInt(System.in.readLine()); }
    public static int[] LI() throws Exception { String[] s = System.in.readLine().split(" "); int[] a = new int[s.length]; for (int i=0; i<s.length; i++) a[i] = Integer.parseInt(s[i]); return a; }
    public static void main(String[] args) throws Exception {
        int N = I();
        int[] S = LI();
        Arrays.sort(S);
        boolean[] flag = new boolean[S.length];
        List<Integer> cur = new ArrayList<>();
        cur.add(S[0]);
        flag[0] = false;
        for (int i=0; i<N; i++) {
            int j = 0;
            int jM = cur.size();
            for (int k=0; k<S.length; k++) {
                if (flag[k] && S[k] < cur.get(j)) {
                    cur.add(S[k]);
                    j++;
                    flag[k] = false;
                    if (j == jM) break;
                }
            } else {
                System.out.println("No");
                return;
            }
            Collections.sort(cur, Collections.reverseOrder());
        }
        System.out.println("Yes");
    }
}