import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class s733189960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Integer> sdic = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            
            if (sdic.containsKey(s)) {
                sdic.put(s, sdic.get(s) + 1);
            } else {
                sdic.put(s, 1);
            }
        }
        
        long ans = 0;
        for (int v : sdic.values()) {
            ans += (long)v * (v - 1) / 2;
        }
        
        System.out.println(ans);
    }
}