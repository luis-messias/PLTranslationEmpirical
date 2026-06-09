import java.util.Scanner;
import java.util.ArrayList;

public class s554393427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<double[]> mo = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String xStr = sc.next();
            String u = sc.next();
            double x = Double.parseDouble(xStr);
            mo.add(new double[]{x, u});
        }
        
        double okz = 0;
        for (double[] item : mo) {
            if (item[1].equals("JPY")) {
                okz += item[0];
            } else {
                okz += item[0] * 380000;
            }
        }
        
        System.out.println(okz);
    }
}
