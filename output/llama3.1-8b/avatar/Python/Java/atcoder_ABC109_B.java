import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC109_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> s = new HashMap<>();
        String f = "Yes";
        for (int i = 0; i < n; i++) {
            String v = scanner.nextLine();
            if (!s.containsKey(v)) {
                s.put(v, 1);
            } else {
                int count = s.get(v) + 1;
                s.put(v, count);
                if (count >= 2) {
                    f = "No";
                }
            }
            if (i != 0 && !v.equals(l[i - 1].substring(l[i - 1].length() - 1))) {
                f = "No";
            }
        }
        System.out.println(f);
    }
}