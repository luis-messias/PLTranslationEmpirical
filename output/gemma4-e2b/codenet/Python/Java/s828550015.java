import java.util.*;
import java.io.*;

public class s828550015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read x, y, a, b, c
        if (!scanner.hasNextInt()) return;
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Read list for p
        List<Integer> pList = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineP = scanner.nextLine();
            StringTokenizer stP = new StringTokenizer(lineP);
            for (int i = 0; i < x; i++) {
                if (stP.hasMoreTokens()) {
                    pList.add(Integer.parseInt(stP.nextToken()));
                }
            }
        }

        // Read list for q
        List<Integer> qList = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineQ = scanner.nextLine();
            StringTokenizer stQ = new StringTokenizer(lineQ);
            for (int i = 0; i < y; i++) {
                if (stQ.hasMoreTokens()) {
                    qList.add(Integer.parseInt(stQ.nextToken()));
                }
            }
        }

        // Read list for r
        List<Integer> rList = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineR = scanner.nextLine();
            StringTokenizer stR = new StringTokenizer(lineR);
            while (stR.hasMoreTokens()) {
                rList.add(Integer.parseInt(stR.nextToken()));
            }
        }

        // Process p: sort descending and take top x
        List<Integer> p = new ArrayList<>(pList);
        p.sort(Collections.reverseOrder());
        p = p.subList(0, Math.min(x, p.size()));

        // Process q: sort descending and take top y
        List<Integer> q = new ArrayList<>(qList);
        q.sort(Collections.reverseOrder());
        q = q.subList(0, Math.min(y, q.size()));

        // Process r: sort descending
        List<Integer> r = new ArrayList<>(rList);
        r.sort(Collections.reverseOrder());

        // Process pq: concatenate p and q, then sort
        List<Integer> pq = new ArrayList<>(p);
        pq.addAll(q);
        Collections.sort(pq, Collections.reverseOrder());

        // Modification loop
        int limit = Math.min(x + y, a + b, c);
        for (int i = 0; i < limit; i++) {
            // Ensure indices are within bounds, although based on the Python logic, 
            // we assume p, q, r are long enough for the comparison up to limit.
            if (i < pq.size() && i < r.size()) {
                if (pq.get(i) < r.get(i)) {
                    pq.set(i, r.get(i));
                }
            }
        }

        // Print sum
        long sum = 0