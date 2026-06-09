import java.util.Scanner;

public class s000375264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int X = Integer.parseInt(parts[0]);
        int t = Integer.parseInt(parts[1]);

        int answer;
        if (X > t) {
            answer = X - t;
        } else {
            answer = 0;
        }

        System.out.println(answer);
    }
}