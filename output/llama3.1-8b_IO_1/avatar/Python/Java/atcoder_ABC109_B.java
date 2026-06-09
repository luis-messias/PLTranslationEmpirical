import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC109_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> s = new HashMap<>();
        String f = "Yes";
        String[] l = new String[n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextLine();
            if (!s.containsKey(l[i])) {
                s.put(l[i], 1);
            } else {
                int count = s.get(l[i]) + 1;
                s.put(l[i], count);
                if (count >= 2) {
                    f = "No";
                }
            }
            if (i != 0 && !l[i].equals(l[i - 1].substring(Math.max(0, l[i - 1].length() - 1)))) {
                f = "No";
            }
        }
        System.out.println(f);
    }
}
