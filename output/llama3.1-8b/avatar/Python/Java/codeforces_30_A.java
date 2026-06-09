import java.util.Scanner;

public class codeforces_30_A {
    public static double task4(double A, double B, int n) {
        for (int X = -1000; X <= 1000; X++) {
            if (Math.pow(X, n) == B / A) {
                return X;
            }
        }
        return "No solution";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        double A = Double.parseDouble(values[0]);
        double B = Double.parseDouble(values[1]);
        int n = Integer.parseInt(values[2]);
        System.out.println(task4(A, B, n));
    }
}