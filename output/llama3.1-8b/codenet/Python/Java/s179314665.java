import java.util.Scanner;

public class s179314665 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        if (A < 10 && B < 10) {
            System.out.println(A * B);
        } else {
            System.out.println(-1);
        }
    }
}