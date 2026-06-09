import java.util.Scanner;
import java.util.Arrays;

public class s002779582 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] input = scanner.nextLine().split(" ");
        int[] Hs = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            Hs[i] = Integer.parseInt(input[i]);
        }

        int ans = 0;
        int maxH = 0;
        for (int H : Hs) {
            if (maxH <= H) {
                ans += 1;
                maxH = H;
            }
        }

        System.out.println(ans);
    }
}