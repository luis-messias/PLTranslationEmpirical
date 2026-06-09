import java.util.*;
import java.util.function.*;

public class atcoder_ABC171_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        int total = Arrays.stream(a).reduce(0, (x, y) -> x ^ y);
        StringBuilder sb = new StringBuilder();
        for (int ai : a) {
            sb.append((ai ^ total)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}