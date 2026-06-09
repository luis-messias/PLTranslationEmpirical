import java.util.*;
import java.io.*;

public class s344468705 {
    static final int INF = 1000000000000000000;
    static final int MOD = 1000000007;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve();
    }
    
    public static void solve() {
        int n = sc.nextInt();
        
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(-INF);
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            num = -num;
            
            if (num >= dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                int idx = binarySearch(dp, num);
                dp.set(idx, num);
            }
        }
        
        System.out.println(dp.size() - 1);
    }
    
    static int binarySearch(ArrayList<Integer> dp, int num) {
        int left = 0;
        int right = dp.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}