import java.util.Scanner;

public class atcoder_ABC168_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read K
        if (!scanner.hasNextInt()) {
            return;
        }
        int K = scanner.nextInt();

        // Read S
        if (!scanner.hasNext()) {
            return;
        }
        String S = scanner.next();

        if (S.length() <= K) {
            System.out.println(S);
        } else {
            // S[:K] + '...'
            System.out.println(S.substring(0, K) + "...");
        }
    }
}
