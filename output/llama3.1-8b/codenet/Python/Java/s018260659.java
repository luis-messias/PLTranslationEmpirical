import java.util.Scanner;

public class s018260659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int cnt = 1;
        while (cnt <= 9) {
            if (N % cnt == 0 && 1 <= N / cnt && N / cnt <= 9) {
                System.out.println("Yes");
                break;
            } else {
                cnt++;
            }
        }
        if (cnt > 9) {
            System.out.println("No");
        }
    }
}