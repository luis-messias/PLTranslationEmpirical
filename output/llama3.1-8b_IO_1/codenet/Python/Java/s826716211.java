import java.util.Scanner;

public class s826716211 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S_d = scanner.next();
        String T = scanner.next();

        int end = S_d.length() - 1;
        int first = end - T.length() + 1;
        while (first >= 0) {
            int t_i = 0;
            for (int s_i = first; s_i <= end; s_i++) {
                if (t_i < T.length() && (T.charAt(t_i) != S_d.charAt(s_i) || S_d.charAt(s_i) != '?')) {
                    break;
                }
                t_i++;
            }
            if (t_i == T.length()) {
                break;
            }

            first--;
            end--;

        }
        if (first < 0) {
            System.out.println("UNRESTORABLE");
            return;
        }

        char[] ans = S_d.toCharArray();
        int t_i = 0;
        for (int i = first; i <= end; i++) {
            ans[i] = T.charAt(t_i);
            t_i++;
        }
        
        String result = new String(ans).replace('?', 'a');
        System.out.println(result);
    }
}
