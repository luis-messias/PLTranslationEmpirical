import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class codeforces_350_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextInt();
        }
        
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cnt[a[i]]++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (t[i] == 1) {
                ArrayList<Integer> crt = new ArrayList<>();
                crt.add(i);
                int x = a[i];
                while (cnt[x] == 1) {
                    crt.add(x);
                    x = a[x];
                }
                if (crt.size() > ans.size()) {
                    ans = new ArrayList<>(crt);
                }
            }
        }
        
        Collections.reverse(ans);
        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i < ans.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
