import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s733189960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> sdic = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String s = sortString(scanner.nextLine().trim());
            if (sdic.containsKey(s)) {
                sdic.put(s, sdic.get(s) + 1);
            } else {
                sdic.put(s, 1);
            }
        }
        
        int ans = 0;
        for (Map.Entry<String, Integer> entry : sdic.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        
        System.out.println(ans);
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}