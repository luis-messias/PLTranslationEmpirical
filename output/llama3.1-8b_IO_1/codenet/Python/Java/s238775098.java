import java.util.Scanner;

public class s238775098 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double res = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            if (parts[1].equals("BTC")) {
                res += Double.parseDouble(parts[0]) * 380000.0;
            } else {
                res += Double.parseDouble(parts[0]);
            }
        }
        System.out.println(res);
    }
}
