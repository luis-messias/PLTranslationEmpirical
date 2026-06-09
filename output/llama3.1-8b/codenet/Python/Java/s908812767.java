import java.util.*;
import java.io.*;

public class s908812767 {
    static int N;
    static List<List<int[]>> V = new ArrayList<>();
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            V.add(new ArrayList<>());
        }
        color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(color, -1);
        }
        while (true) {
            int start = 0;
            for (int i = 1; i <= N; i++) {
                if (color[i] == -1) {
                    start = i;
                    color[start] = 0;
                    break;
                }
            }
            if (start == 0) {
                for (int i = 1; i <= N; i++) {
                    System.out.print(color[i] + " ");
                }
                return;
            } else {
                if (!dfs(start)) {
                    System.out.println("No");
                    return;
                }
            }
        }
    }

    static boolean dfs(int i) {
        for (int[] pair : V.get(i - 1)) {
            int v = pair[0], w = pair[1];
            if ((w & 1) == 0) {
                if (color[v] == -1) {
                    color[v] = color[i - 1];
                } else if (color[v] == color[i - 1]) {
                    continue;
                } else if (color[v] != color[i - 1]) {
                    return false;
                }
            } else {
                if (color[v] == -1) {
                    color[v] = (color[i - 1] ^ 1);
                } else if (color[v] == color[i - 1]) {
                    return false;
                } else if (color[v] != color[i - 1]) {
                    continue;
                }
            }
            dfs(v);
        }
        return true;
    }
}