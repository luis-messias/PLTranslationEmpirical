import java.util.Scanner;

public class atcoder_ABC171_E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int total = 0;
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            total ^= a[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(a[i] ^ total);
            if (i < N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}