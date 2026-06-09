import java.util.*;
import java.io.*;

public class atcoder_ABC120_C {
    static final int MOD = (int)1e9 + 7;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        if(set.size() == 1) {
            System.out.println(0);
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int min = Collections.min(map.values());
        System.out.println(min * 2);
    }
}