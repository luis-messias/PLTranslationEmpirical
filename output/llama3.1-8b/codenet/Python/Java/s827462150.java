import java.util.Scanner;

public class s827462150 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = 0;
        }

        int x = 1, y = 1, z = 1;

        while (x * x + y * y + z * z + x * y + y * z + z * x <= n) {
            while (x * x + y * y + z * z + x * y + y * z + z * x <= n) {
                while (x * x + y * y + z * z + x * y + y * z + z * x <= n) {
                    int i = x * x + y * y + z * z + x * y + y * z + z * x;
                    A[i - 1]++;
                    z++;
                }
                z = 1;
                y++;
            }
            y = 1;
            z = 1;
            x++;
        }

        for (int i : A) {
            System.out.println(i);
        }
    }
}