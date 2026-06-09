import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC140_D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed
            return;
        }
        int N = scanner.nextInt();

        // 2. Read K
        if (!scanner.hasNextInt()) {
            return;
        }
        int K = scanner.nextInt();

        // 3. Read the sequence S (N elements)
        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNext()) {
                S.add(scanner.next());
            } else {
                // Ran out of input before reading N elements
                return;
            }
        }
        
        scanner.close();

        // 4. Calculate seg_cnt
        int seg_cnt = 0;
        // We iterate up to N-2 because we compare i and i+1
        for (int i = 0; i < N - 1; i++) {
            if (!S.get(i).equals(S.get(i + 1))) {
                seg_cnt++;
            }
        }

        // 5. Calculate cur_happy
        // Total pairs = N - 1
        // cur_happy = Total pairs - seg_cnt
        int cur_happy = (N - 1) - seg_cnt;

        // 6. Determine the answer
        int ans;
        if (2 * K >= seg_cnt) {
            ans = N - 1;
        } else {
            ans = cur_happy + 2 * K;
        }

        // 7. Print the result
        System.out.println(ans);
    }
}