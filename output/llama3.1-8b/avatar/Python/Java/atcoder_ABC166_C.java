import java.util.*;

public class atcoder_ABC166_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Integer> p = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            p.add(i);
        }

        Map<Integer, Integer> hp = new HashMap<>();
        input = scanner.nextLine().split(" ");
        for (String s : input) {
            hp.put(Integer.parseInt(s), Integer.parseInt(s));
        }

        Map<Integer, List<Integer>> path = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            path.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            path.get(a).add(b);
            path.get(b).add(a);
        }

        int c = 0;
        for (Map.Entry<Integer, List<Integer>> entry : path.entrySet()) {
            boolean f = false;
            for (Integer j : entry.getValue()) {
                if (hp.get(entry.getKey()) <= hp.get(j)) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                c++;
            }
        }

        System.out.println(c);
    }
}