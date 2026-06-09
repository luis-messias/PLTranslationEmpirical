import java.util.Scanner;

public class codeforces_462_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String s = scanner.nextLine();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count[c - 'A']++;
            }
        }
        java.util.Arrays.sort(count);
        for (int i = 25; i >= 0; i--) {
            if (count[i] >= k) {
                int res = count[i] * count[i];
                System.out.println(res);
                return;
            }
            k -= count[i];
            res += count[i] * count[i];
        }
        System.out.println(count[25] * count[25]);
    }
}
