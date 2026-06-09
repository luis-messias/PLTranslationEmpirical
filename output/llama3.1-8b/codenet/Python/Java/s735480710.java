import java.util.Scanner;
import java.util.Arrays;

public class s735480710 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] a = scanner.nextLine().split(" ");
        String[] b = new String[n];

        for (int i = 1; i < n; i += 2) {
            b[i - 1] = a[i];
        }
        for (int i = 0; i < n; i += 2) {
            if (i < n - 1) {
                b[n - i - 2] = a[i];
            } else {
                b[n - i - 1] = a[i];
            }
        }

        if (n % 2 == 0) {
            System.out.println(String.join(" ", b));
        } else {
            System.out.println(String.join(" ", reverseArray(b)));
        }
    }

    public static String[] reverseArray(String[] array) {
        String[] reversed = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - i - 1];
        }
        return reversed;
    }
}