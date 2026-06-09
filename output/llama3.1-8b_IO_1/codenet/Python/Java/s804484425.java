import java.util.*;

public class s804484425 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Integer>> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                row.add(scanner.nextInt());
            }
            info.add(row);
        }

        info.sort((o1, o2) -> Integer.compare(o2.get(1), o1.get(1)));

        List<List<Integer>> selected = info.subList(0, k);
        List<Integer> selectedOnly = new ArrayList<>();
        List<Integer> selectedChohuku = new ArrayList<>();
        List<Integer> unselectedOnly = new ArrayList<>();

        Map<Integer, Integer> memo = new HashMap<>();
        for (List<Integer> row : selected) {
            int type = row.get(0);
            if (!memo.containsKey(type)) {
                memo.put(type, 1);
                selectedOnly.add(row.get(1));
            } else {
                selectedChohuku.add(row.get(1));
            }
        }

        int cntType = memo.size();
        for (int i = k; i < n; i++) {
            List<Integer> row = info.get(i);
            int type = row.get(0);
            if (!memo.containsKey(type)) {
                memo.put(type, 1);
                unselectedOnly.add(row.get(1));
            }
        }

        int sumSelect = selectedChohuku.stream().mapToInt(Integer::intValue).sum() + selectedOnly.stream().mapToInt(Integer::intValue).sum();
        int ans = cntType * cntType + sumSelect;

        Collections.reverse(unselectedOnly);
        for (int i = 0; i < Math.min(selectedChohuku.size(), unselectedOnly.size()); i++) {
            cntType++;
            sumSelect += unselectedOnly.get(i);
            sumSelect -= selectedChohuku.get(i);
            int tmp = cntType * cntType + sumSelect;
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}
