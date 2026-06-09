import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class codeforces_8_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String recordOfMovements = scanner.nextLine();
        int x = 0;
        int y = 0;
        Map<Character, int[]> dMovement = new HashMap<>();
        dMovement.put('L', new int[]{0, -1});
        dMovement.put('R', new int[]{0, 1});
        dMovement.put('U', new int[]{1, 0});
        dMovement.put('D', new int[]{-1, 0});
        Map<String, String> d = new HashMap<>();
        d.put(x + "," + y, "");
        boolean bug = false;
        
        for (int i = 0; i < recordOfMovements.length(); i++) {
            char move = recordOfMovements.charAt(i);
            int[] temp = {x, y};
            x += dMovement.get(move)[0];
            y += dMovement.get(move)[1];
            String key = x + "," + y;
            
            if (!d.containsKey(key)) {
                for (char step : dMovement.keySet()) {
                    int[] next = new int[]{x + dMovement.get(step)[0], y + dMovement.get(step)[1]};
                    String nextKey = next[0] + "," + next[1];
                    if (!nextKey.equals(key) && d.containsKey(nextKey)) {
                        bug = true;
                        break;
                    }
                }
            } else {
                bug = true;
            }
            
            if (bug) {
                break;
            }
            d.put(key, "");
        }
        
        if (bug) {
            System.out.println("BUG");
        } else {
            System.out.println("OK");
        }
    }
}
