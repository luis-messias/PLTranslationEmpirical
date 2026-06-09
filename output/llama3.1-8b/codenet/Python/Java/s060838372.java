import java.util.Scanner;

public class s060838372 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String K = scanner.next();
        char[] S = scanner.next().toCharArray();

        if (S[Integer.parseInt(K) - 1] == 'A') {
            S[Integer.parseInt(K) - 1] = 'a';
        } else if (S[Integer.parseInt(K) - 1] == 'B') {
            S[Integer.parseInt(K) - 1] = 'b';
        } else {
            S[Integer.parseInt(K) - 1] = 'c';
        }

        System.out.println(new String(S));
    }
}