import java.util.Scanner;

public class s704354119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] l = scanner.nextLine().split(" ");
        double max = -1e9;
        double min = 1e9;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Double.parseDouble(l[i]);
            if (max < Double.parseDouble(l[i])) {
                max = Double.parseDouble(l[i]);
            }
            if (min > Double.parseDouble(l[i])) {
                min = Double.parseDouble(l[i]);
            }
        }

        System.out.println(min + " " + max + " " + sum);
    }
}