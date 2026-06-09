import java.util.Scanner;

public class s182651529 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int K = scanner.nextInt();

        // Read scores
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            score[i] = scanner.nextInt();
        }

        int mae = 0;
        int usiro = K;

        // Loop runs N-K times
        for (int i = 0; i < N - K; i++) {
            if (score[mae] < score[usiro]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            mae++;
            usiro++;
        }

        scanner.close();
    }
}