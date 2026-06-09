import java.util.Scanner;

public class s357377130 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B, K;
        String[] input = scanner.nextLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        if (A + K - 1 >= B - K + 1) {
            while (A <= B) {
                System.out.println(A);
                A++;
            }
        } else {
            int i = 0;
            while (i <= K - 1) {
                System.out.println(A + i);
                i++;
            }
            while (B - K + 1 <= B) {
                System.out.println(B - K + 1);
                K--;
            }
        }
    }
}