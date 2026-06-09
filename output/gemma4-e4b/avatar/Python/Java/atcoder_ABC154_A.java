import java.util.Scanner;

public class atcoder_ABC154_A {

    public static void solve(String S, String T, int A, int B, String U) {
        if (S.equals(U)) {
            A -= 1;
        }
        if (T.equals(U)) {
            B -= 1;
        }
        // Prints A and B separated by a space, mimicking Python's print(A, B)
        System.out.println(A + " " + B);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read S
        String S = scanner.next();
        // Read T
        String T = scanner.next();
        // Read A
        int A = scanner.nextInt();
        // Read B
        int B = scanner.nextInt();
        // Read U
        String U = scanner.next();

        scanner.close();

        solve(S, T, A, B, U);
    }
}