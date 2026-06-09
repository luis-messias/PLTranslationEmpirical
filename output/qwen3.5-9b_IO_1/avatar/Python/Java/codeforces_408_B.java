import java.util.*;
import java.io.*;

public class codeforces_408_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        for (int i = 0; i < t; i++) {
            solution(scanner);
        }
    }
    
    public static void solution(Scanner scanner) {
        String line = scanner.nextLine();
        Map<Character, Integer> boughtCount = new HashMap<>();
        for (char c : line.toCharArray()) {
            boughtCount.put(c, boughtCount.getOrDefault(c, 0) + 1);
        }
        
        String line2 = scanner.nextLine();
        Map<Character, Integer> madeCount = new HashMap<>();
        for (char c : line2.toCharArray()) {
            madeCount.put(c, madeCount.getOrDefault(c, 0) + 1);
        }
        
        int res = 0;
        for (Map.Entry<Character, Integer> entry : madeCount.entrySet()) {
            char color = entry.getKey();
            if (!boughtCount.containsKey(color)) {
                System.out.println(-1);
                return;
            }
            res += Math.min(boughtCount.get(color), madeCount.get(color));
        }
        System.out.println(res);
    }
}
