import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_ABC089_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }
        char[] march = {'M', 'A', 'R', 'C', 'H'};
        int[] marchLis = new int[5];
        for (String s : S) {
            if (Character.isUpperCase(s.charAt(0))) {
                int index = Arrays.asList(march).indexOf(s.charAt(0));
                if (index != -1) {
                    marchLis[index]++;
                }
            }
        }
        long ans = 0;
        for (int x : getCombinations(marchLis, 3)) {
            ans += x[0] * x[1] * x[2];
        }
        System.out.println(ans);
    }

    public static int[][] getCombinations(int[] arr, int k) {
        if (k == 0) return new int[][]{{}};
        List<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < arr.length - k + 1; i++) {
            int[] rest = Arrays.copyOfRange(arr, i + 1, arr.length);
            for (int[] combination : getCombinations(rest, k - 1)) {
                combinations.add(new int[]{arr[i], combination[0]});
            }
        }
        return combinations.toArray(new int[][]{});
    }
}