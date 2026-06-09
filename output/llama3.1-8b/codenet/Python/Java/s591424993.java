import java.util.*;

public class s591424993 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int g = Integer.parseInt(scanner.nextLine().split(" ")[0]);

        List<List<Integer>> pc = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            String[] line = scanner.nextLine().split(" ");
            pc.add(new ArrayList<>(Arrays.asList(Integer.parseInt(line[0]), Integer.parseInt(line[1]))));
        }

        int ans = Integer.MAX_VALUE;

        for (int bit = 1; bit < (1 << d); bit++) {
            int count = 0;
            int sum = 0;
            Set<Integer> nokori = new HashSet<>();
            for (int i = 1; i <= d; i++) {
                nokori.add(i);
            }

            for (int i = 0; i < d; i++) {
                if ((bit & (1 << i)) != 0) {
                    sum += pc.get(i).get(0) * (i + 1) * 100 + pc.get(i).get(1);
                    count += pc.get(i).get(0);
                    nokori.remove(i + 1);
                }
            }

            if (sum < g) {
                int use = Collections.max(nokori);
                int n = Math.min(pc.get(use - 1).get(0), (-(-g + sum) / ((use * 100))));
                count += n;
                sum += n * use * 100;
            }

            if (sum >= g) {
                ans = Math.min(ans, count);
            }
        }
        System.out.println(ans);
    }
}