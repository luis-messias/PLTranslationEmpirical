import java.util.Scanner;

public class codeforces_629_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 368;
        int[] m = new int[N];
        int[] f = new int[N];
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            b += 1;
            
            if (x.equals("M")) {
                m[a] += 2;
                m[b] -= 2;
            } else {
                f[a] += 2;
                f[b] -= 2;
            }
        }
        
        int a = 0;
        int b = 0;
        int c = 0;
        
        for (int i = 0; i < N; i++) {
            a += m[i];
            b += f[i];
            if (Math.min(a, b) > c) {
                c = Math.min(a, b);
            }
        }
        
        System.out.println(c);
    }
}
