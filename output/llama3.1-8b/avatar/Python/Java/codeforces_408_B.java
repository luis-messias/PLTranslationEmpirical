import java.util.*;
import java.io.*;

public class codeforces_408_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t-- > 0) {
            solution(br);
        }
    }

    public static void solution(BufferedReader br) throws IOException {
        String line = br.readLine();
        Map<Character, Integer> boughtCount = new HashMap<>();
        for (char c : line.toCharArray()) {
            boughtCount.put(c, boughtCount.getOrDefault(c, 0) + 1);
        }
        line = br.readLine();
        Map<Character, Integer> madeCount = new HashMap<>();
        for (char c : line.toCharArray()) {
            madeCount.put(c, madeCount.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> entry : madeCount.entrySet()) {
            if (!boughtCount.containsKey(entry.getKey())) {
                System.out.println(-1);
                return;
            }
            res += Math.min(boughtCount.get(entry.getKey()), entry.getValue());
        }
        System.out.println(res);
    }
}