import java.util.*;

public class atcoder_ABC123_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();
        
        int[] a = new int[x];
        for (int i = 0; i < x; i++) {
            a[i] = sc.nextInt();
        }
        
        int[] b = new int[y];
        for (int i = 0; i < y; i++) {
            b[i] = sc.nextInt();
        }
        
        int[] c = new int[z];
        for (int i = 0; i < z; i++) {
            c[i] = sc.nextInt();
        }
        
        List<Integer> ab = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ab.add(a[i] + b[j]);
            }
        }
        
        Collections.sort(ab, Collections.reverseOrder());
        
        List<Integer> abc = new ArrayList<>();
        int limit = Math.min(k, x * y);
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < z; j++) {
                abc.add(ab.get(i) + c[j]);
            }
        }
        
        Collections.sort(abc, Collections.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            System.out.println(abc.get(i));
        }
    }
}
