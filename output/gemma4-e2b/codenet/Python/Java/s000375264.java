import java.util.Scanner;

public class s000375264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read X and t from the input line
        if (scanner.hasNextInt()) {
            int X = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int t = scanner.nextInt();
                int answer;
                if (X > t) {
                    answer = X - t;
                } else {
                    answer = 0;
                }
                System.out.println(answer);
            }
        }
        scanner.close();
    }
}