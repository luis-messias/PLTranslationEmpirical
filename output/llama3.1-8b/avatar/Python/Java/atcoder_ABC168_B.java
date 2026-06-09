import java.util.Scanner;

public class atcoder_ABC168_B {
    public static String main() {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        if (S.length() <= K) {
            return S;
        }
        return S.substring(0, K) + "...";
    }

    public static void main(String[] args) {
        System.out.println(main());
    }
}