import java.util.Scanner;

public class atcoder_ABC168_B {
    public static String main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // K = int(input())
        if (!scanner.hasNextInt()) {
            return ""; // Handle case where K is not provided
        }
        int K = scanner.nextInt();

        // S = input()
        if (!scanner.hasNext()) {
            return ""; // Handle case where S is not provided
        }
        String S = scanner.next();

        if (S.length() <= K) {
            return S;
        } else {
            // S[:K] + '...'
            return S.substring(0, K) + "...";
        }
    }
}