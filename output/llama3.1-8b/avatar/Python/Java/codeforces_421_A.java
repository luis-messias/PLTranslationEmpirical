import java.util.Scanner;

public class codeforces_421_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, a, b;
        String[] input = scanner.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        a = Integer.parseInt(input[1]);
        b = Integer.parseInt(input[2]);

        int[] lista = new int[n];
        int[] listb = new int[n];

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split(" ");
            lista[i] = Integer.parseInt(input[0]);
            listb[i] = Integer.parseInt(input[1]);
        }

        for (int k = 0; k < n; k++) {
            if (k + 1 == a) {
                System.out.print(1 + " ");
            } else {
                System.out.print(2 + " ");
            }
        }
    }
}