import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_134_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            x += w[i];
        }
        
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((x - w[i]) == w[i] * (n - 1)) {
                d.add(i + 1);
            }
        }
        
        System.out.println(d.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.size(); i++) {
            sb.append(d.get(i));
            if (i < d.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
