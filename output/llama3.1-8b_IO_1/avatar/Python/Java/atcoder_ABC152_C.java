import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC152_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] n = new int[N];
        for (int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(input[i]);
        }
        int a = 1;
        int pos = 0;
        for (int i = 1; i < N; i++) {
            if (n[pos] > n[i]) {
                a += 1;
                pos = i;
            }
        }
        System.out.println(a);
    }
}
