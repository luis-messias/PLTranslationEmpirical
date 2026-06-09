import java.util.*;
import java.io.*;

public class atcoder_ABC128_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                row.add(Integer.parseInt(st.nextToken()));
            }
            li.add(row);
        }

        int[] p = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> q = new HashSet<>();
        for (List<Integer> row : li) {
            q.addAll(row);
        }
        Set<Integer> r = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            r.add(i);
        }
        Set<Integer> v = new HashSet<>(r);
        v.removeAll(q);

        long ans = 0;
        for (int i = 0; i <= q.size(); i++) {
            List<Integer> s = new ArrayList<>();
            for (Integer x : q) {
                if (i == 0 || !s.contains(x)) {
                    s.add(x);
                }
            }
            boolean valid = true;
            for (int j = 0; j < m && valid; j++) {
                int count = 0;
                for (int x : s) {
                    if (li.get(j).contains(x)) {
                        count++;
                    }
                }
                if ((count & 1) != p[j]) {
                    valid = false;
                }
            }
            if (valid) {
                ans += Math.pow(2, v.size());
            }
        }
        System.out.println(ans);
    }
}
