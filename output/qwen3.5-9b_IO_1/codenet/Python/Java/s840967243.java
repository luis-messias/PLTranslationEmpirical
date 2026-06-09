import java.util.*;

public class s840967243 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[2];
        for (int i = 0; i < 2; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int n = arr[0];
        int m = arr[1];
        
        long MOD = 1000000007L;
        
        long factN = factorial(n, MOD);
        long factM = factorial(m, MOD);
        
        long term = Math.max(2 - m + n, 0);
        
        long result = (term * factN) % MOD;
        result = (result * factM) % MOD;
        
        System.out.println(result);
    }
    
    public static long factorial(int n, long mod) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % mod;
        }
        return result;
    }
}
