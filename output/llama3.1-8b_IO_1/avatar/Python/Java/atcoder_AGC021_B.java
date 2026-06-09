import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class atcoder_AGC021_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] input = br.readLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        double[][] XY = new double[N][2];
        for (int i = 1; i < input.length; i += 2) {
            XY[i / 2 - 1][0] = Double.parseDouble(input[i]);
            XY[i / 2 - 1][1] = Double.parseDouble(input[i + 1]);
        }
        br.close();

        for (int i = 0; i < N; i++) {
            double[] D = new double[N];
            int j = 0;
            for (double[] xy : XY) {
                if (i != j) {
                    D[j] = Math.atan2(xy[1] - XY[i][1], xy[0] - XY[i][0]);
                }
                j++;
            }
            Arrays.sort(D);
            D[N - 1] += 2 * Math.PI;
            double ans = 0;
            for (int k = 0; k < N - 1; k++) {
                if (D[k + 1] - D[k] >= Math.PI) {
                    ans = D[k + 1] - D[k] - Math.PI;
                }
            }
            System.out.println(ans / (2 * Math.PI));
        }
    }
}
