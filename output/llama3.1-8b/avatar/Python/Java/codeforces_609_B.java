import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_609_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<Integer, Integer> l = new HashMap<>();
        String[] lstStr = scanner.nextLine().split(" ");
        for (String s : lstStr) {
            int num = Integer.parseInt(s);
            if (!l.containsKey(num)) {
                l.put(num, 1);
            } else {
                l.put(num, l.get(num) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (l.get(lstStr[i].parseInt()) > 1) {
                res += n - i - l.get(lstStr[i].parseInt());
                l.put(lstStr[i].parseInt(), l.get(lstStr[i].parseInt()) - 1);
            } else {
                res += n - i - 1;
            }
        }

        System.out.println(res);
    }
}