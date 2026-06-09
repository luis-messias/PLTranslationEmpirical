import java.util.Scanner;

public class s001486412 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] input = scanner.nextLine().split(" ");
        double below = 0;
        for (int i = 0; i < n; i++) {
            below += 1 / Double.parseDouble(input[i]);
        }
        System.out.println(1 / below);
    }
}