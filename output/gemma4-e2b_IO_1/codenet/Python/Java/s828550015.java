import java.util.*;
import java.io.*;

public class s828550015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read x, y, a, b, c
        if (!scanner.hasNextInt()) return;
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Helper function to read a line and parse integers
        // We need to read the next line for p, q, and r.
        
        // 2. Read list for p
        List<Integer> pList = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineP = scanner.nextLine();
            StringTokenizer stP = new StringTokenizer(lineP);
            while (stP.hasMoreTokens()) {
                pList.add(Integer.parseInt(stP.nextToken()));
            }
        }
        
        // 3. Read list for q
        List<Integer> qList = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineQ = scanner.nextLine();
            StringTokenizer stQ = new StringTokenizer(lineQ);
            while (stQ.hasMoreTokens()) {
                qList.add(Integer.parseInt(stQ.nextToken()));
            }
        }

        // 4. Read list for r
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
        // Python slicing [:x] handles cases where list size < x implicitly, 
        // but we ensure we don't go out of bounds if the list is smaller.
        int pSize = Math.min(x, p.size());
        p = p.subList(0, pSize);

        // Process q: sort descending and take top y
        List<Integer> q = new ArrayList<>(qList);
        q.sort(Collections.reverseOrder());
        int qSize = Math.min(y, q.size());
        q = q.subList(0, qSize);

        // Process r: sort descending
        List<Integer> r = new ArrayList<>(rList);
        r.sort(Collections.reverseOrder());

        // Process pq: concatenate p and q, then sort
        List<
