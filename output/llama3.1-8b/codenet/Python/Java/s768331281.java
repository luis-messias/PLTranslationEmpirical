import java.util.Arrays;
import java.util.Scanner;

public class s768331281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String L = scanner.next();
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.next().trim();
        }
        Arrays.sort(S);
        System.out.println(String.join("", S));
    }
}