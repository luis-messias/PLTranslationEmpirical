import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class atcoder_ABC120_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty()) {
            return;
        }

        // Check if all characters are the same
        Set<Character> charSet = s.chars()
                                .mapToObj(c -> (char) c)
                                .collect(java.util.stream.Collectors.toSet());

        if (charSet.size() == 1) {
            System.out.println(0);
            return;
        }

        // Calculate frequencies (Counter equivalent)
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Find the minimum frequency
        int minFreq = Integer.MAX_VALUE;
        for (int freq : counts.values()) {
            if (freq < minFreq) {
                minFreq = freq;
            }
        }

        // Calculate result: min_freq * 2
        int ans = minFreq * 2;
        System.out.println(ans);
    }
}