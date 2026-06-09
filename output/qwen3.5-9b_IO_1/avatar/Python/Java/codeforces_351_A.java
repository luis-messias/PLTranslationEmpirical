import java.util.*;

public class codeforces_351_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextDouble();
        }
        
        List<Double> filtered = new ArrayList<>();
        for (double x : arr) {
            if (x - Math.floor(x) != 0) {
                filtered.add(x - Math.floor(x));
            }
        }
        
        Collections.sort(filtered);
        
        int o = 2 * n - filtered.size();
        double arr_sum = 0;
        for (double x : filtered) {
            arr_sum += x;
        }
        
        double res = Double.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (i + o >= n) {
                res = Math.min(res, Math.abs(i - arr_sum));
            }
        }
        
        System.out.printf("%.3f%n", res);
    }
}
