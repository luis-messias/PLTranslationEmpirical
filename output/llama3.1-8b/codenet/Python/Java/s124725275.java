import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class s124725275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int H = nextInt(br);
        int si = nextInt(br);
        int sj = nextInt(br);
        int ti = nextInt(br);
        int tj = nextInt(br);

        char[][] S = readMapAs(H, "#", '.');
        int[][] D = new int[H][W];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, si - 1, sj - 1});
        while (!que.isEmpty()) {
            int[] cur = que.pollFirst();
            if (D[cur[1]][cur[2]] != -1) continue;
            D[cur[1]][cur[2]] = cur[0];
            for (int di : new int[]{-2, -1, 0, 1, 2}) {
                for (int dj : new int[]{-2, -1, 0, 1, 2}) {
                    int ni = cur[1] + di;
                    int nj = cur[2] + dj;
                    if (!isValid(ni, nj, H, W) || D[ni][nj] != -1 || S[ni][nj] == '#') continue;
                    if (di == 0 && Math.abs(dj) == 1 || dj == 0 && Math.abs(di) == 1) {
                        que.addFirst(new int[]{cur[0], ni, nj});
                    } else {
                        que.addLast(new int[]{cur[0] + 1, ni, nj});
                    }
                }
            }
        }
        System.out.println(D[ti - 1][tj - 1]);
    }

    private static boolean isValid(int i, int j, int H, int W) {
        return 0 <= i && i < H && 0 <= j && j < W;
    }

    private static int nextInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static char[][] readMapAs(int H, char pad, char defaultChar) throws IOException {
        char[][] ret = new char[H][];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            if (s.length() == 0) continue;
            ret[i] = Arrays.copyOf(s.toCharArray(), s.length());
        }
        return ret;
    }

    private static int W;

    private static int[][] readMapAs(int H, char[] replace, char pad) throws IOException {
        W = 0;
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            if (s.length() == 0) continue;
            ret[i] = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                W = Math.max(W, j + 1);
                ret[i][j] = replace[s.charAt(j)] != 0 ? replace[s.charAt(j)] : pad;
            }
        }
        return ret;
    }

    private static BufferedReader br;

    static {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}