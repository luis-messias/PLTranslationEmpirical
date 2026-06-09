import java.util.Scanner;

public class s813548165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        String T = scanner.nextLine();

        StringBuilder charLists = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            charLists.append(S.charAt(i));
            charLists.append(T.charAt(i));
        }

        System.out.println(charLists.toString());
    }
}