import java.util.Scanner;

public class s225615697 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        long m1 = 0;
        for (int i = 0; i < n; i++) {
            m1 += (long) a[i] * Math.pow(-1, i + 1);
        }
        m1 /= 2;

        StringBuilder result = new StringBuilder();
        result.append(m1);

        int[] m = new int[n];
        m[0] = (int) m1;
        for (int i = 1; i < n; i++) {
            m[i] = a[i - 1] - m[i - 1];
        }

        for (int x : m) {
            System.out.print(x * 2 + " ");
        }
    }
}
