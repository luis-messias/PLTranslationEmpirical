import java.util.Scanner;

public class s031459110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String c = sc.next();
        
        int num_w = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == 'W') {
                num_w++;
            }
        }
        
        int num_r = N - num_w;
        
        StringBuilder comp = new StringBuilder();
        for (int i = 0; i < num_r; i++) {
            comp.append('R');
        }
        for (int i = 0; i < num_w; i++) {
            comp.append('W');
        }
        
        int ans = 0;
        for (int i = 0; i < num_r; i++) {
            if (c.charAt(i) != comp.charAt(i)) {
                ans++;
            }
        }
        
        ans = Math.min(num_w, Math.min(num_r, ans));
        System.out.println(ans);
    }
}