import java.io.*;
import java.util.*;

public class codeforces_400_A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static String nextLine() throws IOException {
        return br.readLine().trim();
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) solve();
    }

    static void solve() throws IOException {
        String s = nextLine();
        List<Integer> v = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == 'O') v.add(0);
            else v.add(1);
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 12; i++) {
            if (12 % i == 0) {
                int a = 12 / i;
                int b = i;
                boolean ok = true;
                List<Integer>[] mat = new ArrayList[a];
                for (int j = 0; j < a; j++) {
                    mat[j] = new ArrayList<>();
                    for (int k = 0; k < b; k++) {
                        mat[j].add(v.get(j * b + k));
                    }
                }
                int[] sum = new int[b];
                for (int j = 0; j < a; j++) {
                    for (int k = 0; k < b; k++) {
                        sum[k] += mat[j].get(k);
                    }
                }
                boolean flag = true;
                for (int i1 : sum) if (i1 != b) {flag = false; break;}
                if (flag) set.add(a + "x" + b);
            }
        }
        System.out.println(set.size());
        for (String str : set) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}