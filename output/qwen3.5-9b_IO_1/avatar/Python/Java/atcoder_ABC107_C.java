import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class atcoder_ABC107_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] lst = new int[N];
        for (int i = 0; i < N; i++) {
            lst[i] = sc.nextInt();
        }
        
        ArrayList<Integer> lst_p = new ArrayList<>();
        ArrayList<Integer> lst_m = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            if (lst[i] == 0) {
                K--;
            } else if (lst[i] > 0) {
                lst_p.add(lst[i]);
            } else {
                lst_m.add(lst[i]);
            }
        }
        
        int lastx = lst_p.size();
        int lasty = lst_m.size();
        
        System.out.println(check(K, lst_p, lst_m, lastx, lasty));
    }
    
    private static int check(int k, ArrayList<Integer> lst_p, ArrayList<Integer> lst_m, int lastx, int lasty) {
        int ans = 1000000000;
        for (int j = 0; j <= k; j++) {
            if (j > lastx || k - j > lasty) {
                continue;
            }
            int p = 0;
            int m = 0;
            if (j > 0) {
                p = lst_p.get(j - 1);
            }
            if (k - j > 0) {
                m = lst_m.get(lasty - (k - j));
            }
            ans = Math.min(ans, Math.min(2 * p + Math.abs(m), p + 2 * Math.abs(m)));
        }
        return ans;
    }
}
