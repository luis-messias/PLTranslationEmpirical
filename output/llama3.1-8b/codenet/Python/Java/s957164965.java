import java.util.*;

public class s957164965 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int X = Integer.parseInt(input1[0]);
        int N = Integer.parseInt(input1[1]);

        String[] input2 = scanner.nextLine().split(" ");
        List<Integer> p = new ArrayList<>();
        for (String s : input2) {
            p.add(Integer.parseInt(s));
        }

        Collections.sort(p);

        Map<Integer, List<Integer>> candidates = new HashMap<>();
        for (int i = -1; i <= 102; i++) {

            if (p.contains(i)) {
                continue;
            }

            int absX_i = Math.abs(X - i);
            if (!candidates.containsKey(absX_i)) {
                candidates.put(absX_i, new ArrayList<>(Arrays.asList(i)));
            } else {
                candidates.get(absX_i).add(i);
            }
        }

        int smallest = Collections.min(candidates.keySet());

        List<Integer> candidateList = candidates.get(smallest);
        int minNum = Collections.min(candidateList);

        System.out.println(minNum);
    }
}