import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC107_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int K = scanner.nextInt();

        // Read the list lst
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                lst.add(scanner.nextInt());
            }
        }
        scanner.close();

        // Partitioning
        ArrayList<Integer> lst_p = new ArrayList<>();
        ArrayList<Integer> lst_m = new ArrayList<>();

        for (int val : lst) {
            if (val == 0) {
                K--;
            } else if (val > 0) {
                lst_p.add(val);
            } else if (val < 0) {
                lst_m.add(val);
            }
        }

        // Initialization based on Python code
        int p = 0;
        int m = 0;
        // x, y = 0, len(lst_m) - 1 (unused in the final logic, but kept for fidelity)
        // lastx = len(lst_p)
        int lastx = lst_p.size();
        // lasty = len(lst_m)
        int lasty = lst_m.size();

        // Function check(k) implementation
        // Since p and m are modified within the loop in Python, we must re-initialize them or handle scope carefully in Java.
        // In the Python code, p and m are redefined inside the loop based on j.
        
        long result = check(K, lst_p, lst_m, lastx, lasty);
        System.out.println(result);
    }

    // Helper function equivalent to Python's check(k)
    public static long check(int k, ArrayList<Integer> lst_p, ArrayList<Integer> lst_m, int lastx, int lasty) {
        long ans = 1_000_000_000L;

        for (int j = 0; j <= k; j++) {
            if (j > lastx || k - j > lasty) {
                continue;
            }

            int p_val;
            if (j == 0) {
                p_val = 0;
            } else {
                // p = lst_p[j - 1]
                p_val = lst_p.get(j - 1);
            }

            int m_val;
            if (k - j == 0) {
                m_val = 0;
            } else {
                // m = lst_m[lasty - (k - j)]
                m_val = lst_m.get(lasty - (k - j));
            }

            long current_ans = Math.min(
                2 * p_val + Math.abs(m_val),
                p_val + 2 * Math.abs(m_val)
            );

            ans = Math.min(ans, current_ans);
        }
        return ans;
    }
}