import java.util.*;
import java.io.*;

public class atcoder_AGC013_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // Remove consecutive duplicates (equivalent to groupby)
        List<Integer> uniqueA = new ArrayList<>();
        if (N > 0) {
            uniqueA.add(A[0]);
            for (int i = 1; i < N; i++) {
                if (A[i] != A[i - 1]) {
                    uniqueA.add(A[i]);
                }
            }
        }
        
        N = uniqueA.size();
        int ans = 0;
        for (int i = 1; i < N - 1; i++) {
            if ((uniqueA.get(i - 1) < uniqueA.get(i) && uniqueA.get(i) > uniqueA.get(i + 1)) ||
                (uniqueA.get(i - 1) > uniqueA.get(i) && uniqueA.get(i) < uniqueA.get(i + 1))) {
                ans++;
            }
        }
        
        System.out.println(ans + 1);
    }
}
