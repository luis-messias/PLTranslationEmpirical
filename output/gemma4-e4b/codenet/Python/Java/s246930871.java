import java.util.Scanner;

public class s246930871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int A = Integer.parseInt(parts[1]);
        int B = Integer.parseInt(parts[2]);

        int ans = A * (N / (A + B)) + Math.min(A, N % (A + B));
        System.out.println(ans);
    }
}