import java.util.Scanner;

public class s200092246 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ans = new int[2];
        
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            if (sum < N) {
                continue;
            } else {
                ans[0] = i - 1;
                ans[1] = sum - N;
                break;
            }
        }
        
        for (int i = 0; i < ans[0] + 1; i++) {
            if (i + 1 != ans[1]) {
                System.out.println(i + 1);
            }
        }
    }
}
