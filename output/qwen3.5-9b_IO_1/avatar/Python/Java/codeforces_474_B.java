import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_474_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> L = new ArrayList<>();
        
        // First input line (ignored)
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        
        // Read n elements
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                L.add(i + 1);
            }
        }
        
        // Skip the next line
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        
        // Read queries
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int j = sc.nextInt();
            System.out.println(L.get(j - 1));
        }
        
        sc.close();
    }
}
