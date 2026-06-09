import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class s101447419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read V
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                v.add(scanner.nextInt());
            }
        }

        // Split V into ve and vo
        List<Integer> ve = new ArrayList<>();
        List<Integer> vo = new ArrayList<>();

        for (int i = 0; i < n / 2; i++) {
            ve.add(v.get(2 * i));
            vo.add(v.get(2 * i + 1));
        }

        // Calculate frequencies using HashMaps (equivalent to Counter)
        Map<Integer, Long> ce = new HashMap<>();
        for (int x : ve) {
            ce.put(x, ce.getOrDefault(x, 0L) + 1);
        }

        Map<Integer, Long> co = new HashMap<>();
        for (int x : vo) {
            co.put(x, co.getOrDefault(x, 0L) + 1);
        }

        // Find most common elements and counts
        
        // Helper function to get the most common element and count
        // Since Java Maps don't directly expose most_common(), we need to iterate or sort.
        
        // Get most common for ve
        List<Map.Entry<Integer, Long>> ceMostCommon = new ArrayList<>(ce.entrySet());
        Collections.sort(ceMostCommon, (a, b) -> Long.compare(b.getValue(), a.getValue()));
        
        // Get most common