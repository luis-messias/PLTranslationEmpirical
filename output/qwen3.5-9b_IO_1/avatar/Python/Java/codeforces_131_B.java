import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class codeforces_131_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> w = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            w.put(val, w.getOrDefault(val, 0) + 1);
        }
        
        long c = 0;
        for (Map.Entry<Integer, Integer> entry : w.entrySet()) {
            int i = entry.getKey();
            int count = entry.getValue();
            
            if (i == 0) {
                c += (long)count * (count - 1);
            } else {
                if (w.containsKey(-i)) {
                    c += (long)count * w.get(-i);
                }
            }
        }
        
        System.out.println(c / 2);
    }
}
