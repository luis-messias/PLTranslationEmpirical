import java.util.*;

public class s534639230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int[] D = new int[N];
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            D[i] = sc.nextInt();
            maxVal = Math.max(maxVal, D[i]);
        }
        
        long mod = 998244353L;
        
        if (N == 0 || D[0] != 0) {
            System.out.println(0);
            return;
        }
        
        Map<Integer, Integer> cnt = new HashMap<>();
