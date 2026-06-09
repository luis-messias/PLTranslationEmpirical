import java.util.*;
import java.io.*;

public class atcoder_AGC035_B {
    static int N, M;
    static List<Integer>[] edges = new ArrayList[100];
    static int[] degs = new int[100];
    static int[] parity = new int[100];
    static boolean[] flag = new boolean[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            edges[a].add(b);
            edges[b].add(a);

            degs[a]++;
            degs[b]++;
        }

        if (M % 2 != 0) {
            System.out.println(-1);
            return;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            q.offer(new int[]{degs[i], i});
        }
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int u = arr[1];
            if (flag[u]) continue;
            flag[u] = true;

            for (int v : edges[u]) {
                edges[v].remove((Integer) edges[v].indexOf(u));
                if (parity[u] != 0 && edges[u].indexOf(v) == 0) {
                    System.out.println((u + 1) + " " + (v + 1));
                    parity[u] = 1 - parity[u];
                } else {
                    System.out.println((v + 1) + " " + (u + 1));
                    parity[v] = 1 - parity[v];
                }
                degs[v]--;
                q.offer(new int[]{degs[v], v});
            }
        }
    }
}