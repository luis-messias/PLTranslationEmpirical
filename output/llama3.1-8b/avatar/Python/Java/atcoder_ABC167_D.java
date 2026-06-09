import java.util.*;

public class atcoder_ABC167_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> L = new ArrayList<>();
        input = scanner.nextLine().split(" ");
        for (String s : input) {
            L.add(Integer.parseInt(s));
        }
        L.add(0, -1);

        boolean flag = false;
        int t = -1;

        Map<Integer, Integer> Hash = new HashMap<>();
        List<Integer> path = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            int ne = L.get(i);
            if (Hash.containsKey(ne)) {
                flag = true;
                t = Hash.get(ne);
                break;
            }
            path.add(ne);
            Hash.put(ne, path.size() - 1);
        }

        if (flag) {
            List<Integer> loop = path.subList(t, path.size());
            if (K < path.size()) {
                System.out.println(path.get(K));
            } else {
                K -= path.size();
                K %= loop.size();
                System.out.println(loop.get(K));
            }
        } else {
            System.out.println(path.get(K - 1));
        }
    }
}