import java.util.Scanner;
import java.util.ArrayList;

public class s554393427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayList<double[]> mo = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            double x = Double.parseDouble(input[0]);
            mo.add(new double[]{x, input[1].equals("JPY") ? 1 : 380000});
        }

        double okz = 0;
        for (double[] i : mo) {
            if (i[1] == 1) {
                okz += i[0];
            } else {
                okz += i[0] * i[1];
            }
        }

        System.out.println(okz);
    }
}