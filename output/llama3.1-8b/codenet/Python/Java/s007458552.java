import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class s007458552 {
    public static void main(String[] args) throws Exception {
        System.out.println(solve());
    }

    private static String solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();
        Map<Character, Integer> C = new HashMap<>();

        for (char c : S.toCharArray()) {
            C.put(c, C.getOrDefault(c, 0) + 1);
        }

        return "Yes".equals(String.valueOf(C.getOrDefault('R', 0)).compareTo(String.valueOf(n - C.getOrDefault('R', 0))) > 0) ? "Yes" : "No";
    }
}