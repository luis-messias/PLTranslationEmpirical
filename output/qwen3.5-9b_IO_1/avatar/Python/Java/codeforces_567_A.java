import java.util.Scanner;

public class codeforces_567_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] lista = new int[n];
        for (int i = 0; i < n; i++) {
            lista[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println(lista[1] - lista[0] + " " + (lista[n - 1] - lista[0]));
            } else if (i == n - 1) {
                System.out.println(lista[n - 1] - lista[n - 2] + " " + (lista[n - 1] - lista[0]));
            } else if (lista[i] - lista[i - 1] > lista[i + 1] - lista[i]) {
                System.out.print(lista[i + 1] - lista[i] + " ");
            } else {
                System.out.print(lista[i] - lista[i - 1] + " ");
            }
            if (lista[n - 1] - lista[i] > lista[i] - lista[0]) {
                System.out.println(lista[n - 1] - lista[i]);
            } else {
                System.out.println(lista[i] - lista[0]);
            }
        }
    }
}
