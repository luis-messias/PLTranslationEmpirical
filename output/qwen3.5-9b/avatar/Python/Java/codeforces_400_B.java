import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class codeforces_400_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Set<Integer> c = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int sPos = s.indexOf("S");
            int gPos = s.indexOf("G");
            c.add(sPos - gPos);
        }
        
        if (c.stream().anyMatch(a -> a < 0)) {
            System.out.println(-1);
        } else {
            System.out.println(c.size());
        }
    }
}