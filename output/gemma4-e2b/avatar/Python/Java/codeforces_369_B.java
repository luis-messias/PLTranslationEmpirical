import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_369_B {

    public static List<Integer> getNums(int num, int t) {
        List<Integer> result = new ArrayList<>();
        int q = t / num;
        int r = t % num;

        for (int i = 0; i < num; i++) {
            if (i < r) {
                result.add(q + 1);
            } else {
                result.add(q);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n, k, l, r, sa, sk
        // The input is expected to be space-separated integers
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int sa = scanner.nextInt();
            int sk = scanner.nextInt();

            // Calculate the two parts
            List<Integer> part1 = getNums(k, sk);
            List<Integer> part2 = getNums(n - k, sa - sk);

            // Combine the results (Python uses + for list concatenation)
            List<Integer> ans = new ArrayList<>();
            ans.addAll(part1);
            ans.addAll(part2);

            // Print the result joined by spaces
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.size(); i++) {
                sb.append(ans.get(i));
                if (i < ans.size() - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
        
        scanner.close();
    }
}