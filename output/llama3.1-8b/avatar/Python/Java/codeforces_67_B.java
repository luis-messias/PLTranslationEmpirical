import java.util.Scanner;

public class codeforces_67_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        int[] M = new int[n];
        for (int i = 0; i < n; i++) {
            M[i] = Integer.parseInt(scanner.nextLine());
        }

        int m = 0;
        for (int j = 0; j < n; j++) {
            for (int p = 0; p < n; p++) {
                if (M[p] == 0) {
                    System.out.print((p + 1) + " ");
                    break;
                }
            }
            for (int l = Math.max(0, p - k); l <= p; l++) {
                M[l]--;
            }
            M[p]--;
        }
    }
}