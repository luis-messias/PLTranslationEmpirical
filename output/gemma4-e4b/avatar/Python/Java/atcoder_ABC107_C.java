import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC107_C {

    public static long check(int k, List<Integer> lstP, List<Integer> lstM, int lastX, int lastY) {
        long ans = Long.MAX_VALUE;

        for (int j = 0; j <= k; j++) {
            int countP = j;
            int countM = k - j;

            if (countP > lastX || countM > lastY) {
                continue;
            }

            long p;
            if (countP == 0) {
                p = 0;
            } else {
                // p is the j-th positive number (0-indexed)
                p = lstP.get(countP - 1);
            }

            long m;
            if (countM == 0) {
                m = 0;
            } else {
                // Indexing logic: select the countM-th element from the end of lstM
                // Index = lastY - countM
                m = lstM.get(lastY - countM);
            }

            // Calculate minimum cost: min(2*p + |m|, p + 2*|m|)
            long cost1 = 2 * p + Math.abs(m);
            long cost2 = p + 2 * Math.abs(m);
            
            ans = Math.min(ans, Math.min(cost1, cost2));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Read the list lst
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                lst.add(scanner.nextInt());
            }
        }
        scanner.close();

        List<Integer> lstP = new ArrayList<>();
        List<Integer> lstM = new ArrayList<>();

        // Preprocessing
        for (int i = 0; i < N; i++) {
            int val = lst.get(i);
            if (val == 0) {
                K--;
            } else if (val > 0) {
                lstP.add(val);
            } else { // val < 0
                lstM.add(val);
            }
        }

        int lastX = lstP.size();
        int lastY = lstM.size();

        // Calculate and print the result
        long result = check(K, lstP, lstM, lastX, lastY);
        System.out.println(result);
    }
}