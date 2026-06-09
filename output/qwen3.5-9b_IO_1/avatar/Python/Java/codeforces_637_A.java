import java.util.*;
import java.io.*;

public class codeforces_637_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        s = s.substring(0, s.length() - 1);
        Map<Character, Integer> w = new HashMap<>();
        for (char c : s.toCharArray()) {
            w.put(c, w.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder(s);
        String reversedS = sb.reverse().toString();
        int c = -1;
        char a = 0;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : w.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                c = -1;
                a = entry.getKey();
            }
        }
        for (Map.Entry<Character, Integer> entry : w.entrySet()) {
            if (entry.getValue() == maxCount) {
                if (reversedS.indexOf(entry.getKey()) > c) {
                    c = reversedS.indexOf(entry.getKey());
                    a = entry.getKey();
                }
            }
        }
        System.out.println(a);
    }
}
