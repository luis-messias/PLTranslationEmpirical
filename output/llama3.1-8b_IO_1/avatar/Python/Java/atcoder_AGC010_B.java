import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC010_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputStr = scanner.nextLine().split(" ");
        int[] a = new int[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            a[i] = Integer.parseInt(inputStr[i]);
        }
        
        if (Arrays.stream(a).sum() % (n * (n + 1) / 2) != 0) {
            System.out.println("NO");
        } else {
            double k = Arrays.stream(a).sum() / (double) (n * (n + 1) / 2);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, a.length);
            
            if (Arrays.stream(b, 1, b.length)
                    .map(i -> ((int) k - i + b[i]) % n)
                    .sum() != 0 || Arrays.stream(b, 1, b.length)
                            .mapToDouble(i -> (k - i + b[i]) / n)
                            .filter(x -> x >= 0)
                            .count() != n) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
