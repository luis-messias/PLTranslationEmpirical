import java.util.*;
public class s101447419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(input[i]);
        }
        List<Integer> ve = new ArrayList<>();
        List<Integer> vo = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            ve.add(v[2 * i]);
            vo.add(v[2 * i + 1]);
        }
        Map<Integer, Integer> ce = new HashMap<>();
        Map<Integer, Integer> co = new HashMap<>();
        for (Integer num : ve) {
            ce.put(num, ce.getOrDefault(num, 0) + 1);
        }
        for (Integer num : vo) {
            co.put(num, co.getOrDefault(num, 0) + 1);
        }
        int ans = n;
        if (!ce.keySet().equals(co.keySet())) {
            ans -= Math.min(ce.values().stream().findFirst().orElse(0), co.values().stream().findFirst().orElse(0));
        } else if (ce.size() == 1 && co.size() == 1) {
            ans -= ce.values().stream().findFirst().orElse(0);
        } else if (ce.size() == 1) {
            ans -= Math.min(ce.values().stream().findFirst().orElse(0), co.values().stream().skip(1).findFirst().orElse(0));
        } else if (co.size() == 1) {
            ans -= Math.min(co.values().stream().findFirst().orElse(0), ce.values().stream().skip(1).findFirst().orElse(0));
        } else {
            int min1 = Math.min(ce.values().stream().findFirst().orElse(0), co.values().stream().skip(1).findFirst().orElse(0));
            int min2 = Math.min(co.values().stream().findFirst().orElse(0), ce.values().stream().skip(1).findFirst().orElse(0));
            ans -= Math.min(min1, min2);
        }
        System.out.println(ans);
    }
}
