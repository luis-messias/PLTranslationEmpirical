import java.util.*;

public class s289483518 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        
        int[][] ope = new int[m][2];
        for (int i = 0; i < m; i++) {
            ope[i][0] = sc.nextInt();
            ope[i][1] = sc.nextInt();
        }
        
        Arrays.sort(ope, (x, y) -> Integer.compare(y[1], x[1]));
        
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < ope[j][1]) {
                a[i] = ope[j][1];
                ope[j][0]--;
                if (ope[j][0] == 0) {
                    j++;
                    if (j == m) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        
        int sum = 0;
        for (int val : a) {
            sum += val;
        }
        System.out.println(sum);
    }
}
