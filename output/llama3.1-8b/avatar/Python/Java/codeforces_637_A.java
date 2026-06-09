import java.util.*;
import java.io.*;

public class codeforces_637_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine().substring(0, br.readLine().length() - 1);
        String[] words = s.split(" ");
        Map<String, Integer> w = new HashMap<>();
        for (String word : words) {
            w.put(word, w.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(w.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int c = -1;
        String a = "";
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() == list.get(0).getValue()) {
                if (s.lastIndexOf(entry.getKey()) > c) {
                    a = entry.getKey();
                    c = s.lastIndexOf(entry.getKey());
                }
            }
        }
        System.out.println(a);
    }
}