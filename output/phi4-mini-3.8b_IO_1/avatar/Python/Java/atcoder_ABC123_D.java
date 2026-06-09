import java.util.ArrayList;
import java.util.Collections;

public class atcoder_ABC123_D {
    public static void main(String[] args) throws Exception {
        String input = "1 2\n3 4\n5 6\n7"; // Replace this with actual user input reading mechanism

        int x = Integer.parseInt(input.split(" ")[0]);
        int y = Integer.parseInt(input.split(" ")[1]);

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 2; i < len + 2; i++) {
            a.add(Integer.parseInt(input.substring(i, i+1)));
        }

        ArrayList<Integer> b = new ArrayList<>(a.subList(0, x));
        ArrayList<Integer> c = new ArrayList<>(a.subList(x, y));

        int k = Integer.parseInt(input.split(" ")[len + 2]);

        ArrayList<Integer> ab = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                ab.add(a.get(i) + b.get(j));
            }
        }

        Collections.sort(ab, Collections.reverseOrder());

        int minKxy = Math.min(k, x * y);
        ArrayList<Integer> abc = new ArrayList<>();
        for (int i = 0; i < minKxy; i++) {
            for (int j = 0; j < c.size(); j++) {
                abc.add(ab.get(i) + c.get(j));
            }
        }

        Collections.sort(abc, Collections.reverseOrder());

        for (int i = 0; i < k && i < abc.size(); i++) {
            System.out.println(abc.get(i));
        }
    }
}
