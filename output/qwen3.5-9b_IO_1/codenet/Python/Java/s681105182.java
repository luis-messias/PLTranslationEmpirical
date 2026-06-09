import java.util.*;
import java.io.*;

public class s681105182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] a = new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        
        Arrays.sort(a);
        
        int n = a[N - 1];
        
        double dif = 1e18;
        double prevDif = dif;
        int r = 0;
        
        for (int i = 0; i < N - 1; i++) {
            double currentDif = Math.min(Math.abs(n / 2.0 - a[i]), dif);
            if (currentDif != prevDif) {
                r = a[i];
                prevDif = currentDif;
            }
        }
        
        System.out.println(n + " " + r);
    }
}
