import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC123_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] menu = new int[5][2];
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            int e = Integer.parseInt(input.substring(input.length() - 1));
            if (e == 0) {
                e = 10;
            }
            menu[i][0] = Integer.parseInt(input);
            menu[i][1] = e;
        }
        Arrays.sort(menu, (a, b) -> a[1] - b[1]);
        int ans = 0;
        for (int i = 1; i < 5; i++) {
            ans += (int) Math.ceil((double) menu[i][0] / 10) * 10;
        }
        System.out.println(ans + menu[0][0]);
    }
}