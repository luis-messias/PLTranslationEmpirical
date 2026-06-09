import java.util.Scanner;

public class s895229833 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(input[i]);
        }

        int count_best = 0, count_tmp = 0;

        for (int i = 0; i < N - 1; i++) {
            if (H[i] >= H[i + 1]) {
                count_tmp++;
            } else {
                if (count_tmp > count_best) {
                    count_best = count_tmp;
                }
                count_tmp = 0;
            }
        }

        if (count_tmp > count_best) {
            count_best = count_tmp;
        }

        System.out.println(count_best);
    }
}