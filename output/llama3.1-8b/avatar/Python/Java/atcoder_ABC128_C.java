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
            for (List<Integer> s : combinations(q, i)) {
                boolean valid = true;
                for (int j = 0; j < m && valid; j++) {
                    if ((s.stream().filter(x -> li.get(j).contains(x)).count() & 1) != p[j]) {
                        valid = false;
                    }
                }
                if (valid) {
                    ans += Math.pow(2, v.size());
                }
            }
        }
        System.out.println(ans);
    }

    public static <T> List<List<T>> combinations(List<T> list, int size) {
        List<List<T>> result = new ArrayList<>();
        combination(list, 0, new ArrayList<>(), result, size);
        return result;
    }

    private static <T> void combination(List<T> list, int start, List<T> current, List<List<T>> result, int size) {
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            current.add(list.get(i));
            combination(list, i + 1, current, result, size);
            current.remove(current.size() - 1);
        }
    }
}