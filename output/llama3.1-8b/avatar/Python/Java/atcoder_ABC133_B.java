import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC133_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        double[][] points = new double[n][d];
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split(" ");
            for (int j = 0; j < d; j++) {
                points[i][j] = Double.parseDouble(input[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = calculateDistance(points[i], points[j]);
                if (dist == Math.floor(dist)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static double calculateDistance(double[] point1, double[] point2) {
        double sum = 0;
        for (int i = 0; i < point1.length; i++) {
            sum += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(sum);
    }
}