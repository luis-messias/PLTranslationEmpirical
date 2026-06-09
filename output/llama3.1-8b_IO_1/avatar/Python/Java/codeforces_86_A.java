import java.util.Scanner;

public class codeforces_86_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);

        long curr = (long)r;
        long s = 0;
        while (curr > 0) {
            s++;
            curr /= 10;
        }

        long first = (long)Math.pow(10, s);
        long second = first / 2;

        long ans = -1;
        for (int i : new int[] {l, r, (int)first, (int)second}) {
            if (i >= l && i <= r) {
                curr = i;
                String rev = "";
                for (char c : String.valueOf(curr).toCharArray()) {
                    rev += (9 - Character.getNumericValue(c));
                }
                ans = Math.max(ans, Long.parseLong(rev) * curr);
            }
        }

        System.out.println(ans);
    }
}
