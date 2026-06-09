import java.util.Scanner;

public class s538657784 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= N; i++) {
            if (N % i == 0 && i * i + i - 2 == N) {
                System.out.println(i);
                break;
            }
        }
    }
}
