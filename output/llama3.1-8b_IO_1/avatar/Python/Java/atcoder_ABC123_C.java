import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC123_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.next());
        int[] A = new int[5];
        for (int i = 0; i < 5; i++) {
            A[i] = Integer.parseInt(scanner.next());
        }
        System.out.println((int) Math.ceil((double) N / Arrays.stream(A).min().getAsInt()) + 4);
    }
}
