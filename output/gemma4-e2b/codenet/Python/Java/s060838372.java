import java.util.Scanner;

public class s060838372 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K from the first line
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int K = scanner.nextInt();

        // Read S from the second line
        if (!scanner.hasNext()) return;
        String S = scanner.next();

        // K is 1-based index, so the 0-based index is K-1
        if (K > 0 && K <= S.length()) {
            char target = S.charAt(K - 1);

            if (target == 'A') {
                // Replace S[K-1] with 'a'
                S = S.substring(0, K - 1) + 'a' + S.substring(K);
            } else if (target == 'B') {
                // Replace S[K-1] with 'b'
                S = S.substring(0, K - 1) + 'b' + S.substring(K);
            } else {
                // Replace S[K-1] with 'c'
                S = S.substring(0, K - 1) + 'c' + S.substring(K);
            }
        }

        System.out.println(S);
    }
}