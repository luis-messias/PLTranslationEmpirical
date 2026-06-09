import java.util.Scanner;

public class atcoder_ABC154_A {

    public static void solve(String S, String T, int A, int B, String U) {
        if (S.equals(U)) {
            A -= 1;
        }
        if (T.equals(U)) {
            B -= 1;
        }
        System.out.println(A + " " + B);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The Python code reads 5 tokens sequentially: S, T, A, B, U.
        // We read them directly from the input stream.

        if (scanner.hasNext()) {
            String S = scanner.next();
            String T = scanner.next();
            
            if (scanner.hasNextInt()) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                String U = scanner.next();
                
                solve(S, T, A, B, U);
            }
        }

        scanner.close();
    }
}