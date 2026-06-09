import java.util.HashMap;
import java.util.Map;

public class codeforces_8_B {
    public static void main(String[] args) {
        String recordOfMovements = "LURDL";
        int x = 0, y = 0;
        Map<Character, int[]> dMovement = new HashMap<>();
        dMovement.put('L', new int[]{0, -1});
        dMovement.put('R', new int[]{0, 1});
        dMovement.put('U', new int[]{1, 0});
        dMovement.put('D', new int[]{-1, 0});

        Map<String, String> d = new HashMap<>();
        boolean bug = false;

        for (char move : recordOfMovements.toCharArray()) {
            int[] temp = {x, y};
            x += dMovement.get(move)[0];
            y += dMovement.get(move)[1];

            if (!d.containsKey(x + "," + y)) {
                for (Map.Entry<Character, int[]> entry : dMovement.entrySet()) {
                    if ((x + entry.getValue()[0], y + entry.getValue()[1]) != temp && d.containsKey((x + entry.getValue()[0]) + "," + (y + entry.getValue()[1]))) {
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
            d.put(x + "," + y, "");
        }

        if (bug) {
            System.out.println("BUG");
        } else {
            System.out.println("OK");
        }
    }
}
