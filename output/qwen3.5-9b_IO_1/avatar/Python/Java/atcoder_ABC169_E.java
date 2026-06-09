import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC169_E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] low = new int[n];
        int[] high = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            low[i] = a;
            high[i] = b;
        }
        Arrays.sort(low);
        Arrays.sort(high);
        if (n % 2 != 0) {
            System.out.println(high[(n + 1) / 2 - 1] - low[(n + 1) / 2 - 1] + 1);
        } else {
            double hh = (high[n / 2 - 1] + high[n / 2]) / 2.0;
            double ll = (low[n / 2 - 1] + low[n / 2]) / 2.0;
            System.out.println((int)((hh - ll) * 2) + 1);
        }
    }
}
