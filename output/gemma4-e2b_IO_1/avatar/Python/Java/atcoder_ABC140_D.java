import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC140_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read K
        if (!scanner.hasNextInt()) return;
        int K = scanner.nextInt();

        // Read the sequence S (N elements)
        List<Integer> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            S.add(scanner.nextInt());
        }

        // Calculate seg_cnt: number of segments where S[i] != S[i+1]
        int seg_cnt = 0;
        if (N > 1) {
            for (int i = 0; i < N - 1; i++) {
                if (!S.get(i).equals(S.get(i + 1))) {
                    seg_cnt++;
                }
            }
        }

        // Calculate cur_happy
        // Python: cur_happy = N - 1 - seg_cnt
        int cur_happy = N - 1 - seg_cnt;

        // Calculate ans
        int ans;
        if (2 * K >= seg_cnt) {
            ans = N - 1;
        } else {
            ans = cur_happy + 2 * K;
        }

        System.out.println(ans);
        
        scanner.close();
    }
}
