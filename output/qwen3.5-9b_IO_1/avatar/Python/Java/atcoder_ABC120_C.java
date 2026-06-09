import java.util.*;
import java.io.*;

public class atcoder_ABC120_C {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (s == null || s.length() == 0) {
            return;
        }
        
        if (s.chars().distinct().count() == 1) {
            System.out.println(0);
            return;
        }
        
        Map<Character, Integer> a = new HashMap<>();
        for (char c : s.toCharArray()) {
            a.put(c, a.getOrDefault(c, 0) + 1);
        }
        
        int minFreq = Integer.MAX_VALUE;
        for (int freq : a.values()) {
            minFreq = Math.min(minFreq, freq);
        }
        
        System.out.println(minFreq * 2);
    }
}
