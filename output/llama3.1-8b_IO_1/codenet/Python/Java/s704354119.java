import java.util.Scanner;

public class s704354119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        String[] l = scanner.nextLine().split(" ");
        
        double max = -1e9;
        double min = 1e9;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            try {
                int num = Integer.parseInt(l[i]);
                sum += num;
                if (max < num) {
                    max = num;
                }
                if (min > num) {
                    min = num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
        }

        System.out.println(min + " " + max + " " + sum);
    }
}
