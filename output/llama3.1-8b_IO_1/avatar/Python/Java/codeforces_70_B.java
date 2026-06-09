import java.util.Scanner;
import java.util.regex.Pattern;

public class codeforces_70_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();
        String[] sentences = Pattern.compile("[.?!]").split(text);
        int sumL = 0;
        int ans = 1;

        for (String s : sentences) {
            s = s.trim() + ".";
            if (s.length() > 1) {
                if (s.length() > n) {
                    System.out.println("Impossible");
                    return;
                }
                boolean flag = sumL > 0;
                if (sumL + s.length() + (flag ? 1 : 0) > n) {
                    ans++;
                    sumL = s.length();
                } else {
                    sumL += s.length() + (flag ? 1 : 0);
                }
            }
        }

        System.out.println(ans);
    }
}
