import java.util.Scanner;

public class codeforces_421_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]);
        int a = Integer.parseInt(parts[1]);
        int b = Integer.parseInt(parts[2]);

        int[] lista = new int[n];
        int[] listb = new int[n];

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            parts = input.split(" ");
            lista[i] = Integer.parseInt(parts[0]);
            listb[i] = Integer.parseInt(parts[1]);
        }

        for (int k = 0; k < n; k++) {
            if (lista[k] == a) {
                System.out.print(1 + " ");
            } else {
                System.out.print(2 + " ");
            }
        }
    }
}
