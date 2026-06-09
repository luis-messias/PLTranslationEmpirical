import java.util.Scanner;

public class s609392609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] t = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            t[i] = Integer.parseInt(input[i]);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] px = scanner.nextLine().split(" ");
            int p = Integer.parseInt(px[0]);
            int x = Integer.parseInt(px[1]);
            int s = 0;
            for (int j = 0; j < t.length; j++) {
                if (j == p - 1) {
                    s += x;
                } else {
                    s += t[j];
                }
            }
            System.out.println(s);
        }
    }
}