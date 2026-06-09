import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class codeforces_404_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextLine();
        }
        boolean flag = false;
        Set<Character> d1 = new HashSet<>();
        Set<Character> d2 = new HashSet<>();
        Set<Character> rem = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    d1.add(s[i].charAt(j));
                }
                if (i == n - j - 1) {
                    d2.add(s[i].charAt(j));
                }
                if (i != j && i != n - j - 1) {
                    rem.add(s[i].charAt(j));
                }
            }
        }
        if (rem.size() != 1) {
            System.out.println("NO");
        } else if (!d1.equals(d2)) {
            System.out.println("NO");
        } else if (d1.size() != 1) {
            System.out.println("NO");
        } else if (d1.equals(rem)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}