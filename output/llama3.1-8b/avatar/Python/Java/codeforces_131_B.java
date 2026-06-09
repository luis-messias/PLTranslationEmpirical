import java.util.*;
import java.io.*;

public class codeforces_131_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> w = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for (String s : input) {
            w.put(Integer.parseInt(s), w.getOrDefault(Integer.parseInt(s), 0) + 1);
        }
        long c = 0;
        for (int i : w.keySet()) {
            if (i == 0) {
                c += (long) w.get(i) * (w.get(i) - 1);
            } else {
                if (w.containsKey(-i)) {
                    c += (long) w.get(i) * w.get(-i);
                }
            }
        }
        System.out.println(c / 2);
    }
}