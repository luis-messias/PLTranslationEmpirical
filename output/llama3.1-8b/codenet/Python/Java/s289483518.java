import java.util.*;
import java.util.stream.Collectors;

public class s289483518 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> a = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<int[]> ope = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] operation = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ope.add(operation);
        }

        ope.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) < ope.get(j)[1]) {
                a.set(i, ope.get(j)[1]);
                ope.get(j)[0] -= 1;
                if (ope.get(j)[0] == 0) {
                    j++;
                    if (j == ope.size()) break;
                }
            } else {
                break;
            }
        }

        int sum = a.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}