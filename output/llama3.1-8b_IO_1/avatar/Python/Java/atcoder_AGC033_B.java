import java.util.Scanner;

public class atcoder_AGC033_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        System.out.println(solve(n, s));
    }

    public static String solve(int n, String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int j = 0;
            while (j < n - i - 2 && a[j] == 'R') {
                j++;
            }
            if (j >= n - i - 2) {
                return "No";
            }
            for (int k = j + 1; k <= n - i - 2; k++) {
                char temp = a[k];
                a[k] = a[j + 1];
                a[j + 1] = temp;
                j++;
            }
        }
        return "Yes";
    }
}
