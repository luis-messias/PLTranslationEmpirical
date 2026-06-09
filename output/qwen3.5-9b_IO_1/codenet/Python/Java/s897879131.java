import java.util.Scanner;

public class s897879131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int G = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        
        int score = 0;
        for (int i = 0; i <= N / R; i++) {
            for (int j = 0; j <= (N - i * R) / G; j++) {
                if (N - i * R - j * G >= 0 && (N - i * R - j * G) % B == 0) {
                    score++;
                }
            }
        }
        
        System.out.println(score);
    }
}
