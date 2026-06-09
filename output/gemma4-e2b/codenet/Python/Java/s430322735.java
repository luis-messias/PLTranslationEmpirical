import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class s430322735 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after n

        List<String> lst = new ArrayList<>();

        // Read n lines of input and process them
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // st = ''.join(sorted(list(input())))
                char[] chars = line.toCharArray();
                java.util.Arrays.sort(chars);
                String st = new String(chars);
                lst.add(st);
            }
        }

        // lst = sorted(lst)
        Collections.sort(lst);

        // lst += ['end']
        lst.add("end");

        // The rest of the logic
        String pre = "";
        int tmp_cnt = 0;
        long cnt = 0; // Use long for cnt just in case, although the Python result fits in standard int range for typical constraints.

        for (String i : lst) {
            if (i.equals(pre)) {
                tmp_cnt += 1;
            } else {
                // cnt += sum([j for j in range(tmp_cnt + 1)])
                // sum(0 to tmp_cnt) = tmp_cnt * (tmp_cnt + 1) / 2
                long sum_val = (long) tmp_cnt * (tmp_cnt + 1) / 2;
                cnt += sum_val;
                tmp_cnt = 0;
            }
            pre = i;
        }

        System.out.println(cnt);
        scanner.close();
    }
}