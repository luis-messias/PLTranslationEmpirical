import java.util.Scanner;

public class s182651529 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = scanner.nextInt();
        }
        int mae = 0;
        int usiro = K - 1;
        for (int i = 0; i < N - K + 1; i++) {
            if (score[mae] > score[usiro]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            mae++;
            usiro++;
        }
    }
}
