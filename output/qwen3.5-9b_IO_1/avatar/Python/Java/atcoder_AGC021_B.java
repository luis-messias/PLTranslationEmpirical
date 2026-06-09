import java.util.*;
import java.io.*;

public class atcoder_AGC021_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int[] X = new int[N];
        int[] Y = new int[N];
        
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(tokens[2 * i + 1]);
            Y[i] = Integer.parseInt(tokens[2 * i + 2]);
        }
        
        double maxAns = 0;
        for (int i = 0; i < N; i++) {
            List<Double> angles = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    angles.add(Math.atan2(Y[j] - Y[i], X[j] - X[i]));
                }
            }
            Collections.sort(angles);
            angles.add(angles.get(0) + 2 * Math.PI);
            
            double ans = 0;
            for (int k = 0; k < angles.size() - 1; k++) {
                double a = angles.get(k);
                double b = angles.get(k + 1);
                if (b - a >= Math.PI) {
                    ans = Math.max(ans, b - a - Math.PI);
                }
            }
            maxAns = Math.max(maxAns, ans);
        }
        
        System.out.println(maxAns / (2 * Math.PI));
    }
}
