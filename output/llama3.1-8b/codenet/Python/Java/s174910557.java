import java.util.Scanner;

public class s174910557 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();

        int ans = 1;
        char tmp = S.charAt(0);

        for (char c : S.toCharArray()) {
            if (c != tmp) {
                ans++;
                tmp = c;
            }
        }

        System.out.println(ans);
    }
}