import java.util.*;
public class atcoder_ABC112_C {
    public static String solve(int n, int[][] ls_xyh) {
        int x0 = -1;
        for (int i = 0; i < n; i++) {
            if (ls_xyh[i][2] > 0) {
                int[] temp = ls_xyh[i];
                x0 = temp[0];
                break;
            }
        }
        List<int[]> cands = new ArrayList<>();
        for (int cx = 0; cx < 101; cx++) {
            for (int cy = 0; cy < 101; cy++) {
                int h0 = ls_xyh[0][2] + Math.abs(cx - x0) + Math.abs(cy - ls_xyh[0][1]);
                cands.add(new int[]{cx, cy, h0});
            }
        }
        for (int[] xyh : ls_xyh) {
            List<int[]> temp = new ArrayList<>();
            for (int[] cand : cands) {
                if (Math.max(cand[2] - Math.abs(cand[0] - xyh[0]) - Math.abs(cand[1] - xyh[1]), 0) == xyh[2]) {
                    temp.add(cand);
                }
            }
            cands = temp;
        }
        int[] result = cands.get(0);
        return String.join(" ", Arrays.toString(result).replaceAll("\\[|\\]", "").split(","));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ls_xyh = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ls_xyh[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, ls_xyh));
    }
}