import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_268_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String[]> q = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] a = scanner.nextLine().split(" ");
            q.add(a);
        }
        
        int count = 0;
        for (String[] j : q) {
            for (String[] k : q) {
                if (k == null || k.length == 0) continue;
                if (!j[0].equals(k[k.length - 1])) continue;
                count++;
            }
        }
        
        System.out.println(count);
    }
}