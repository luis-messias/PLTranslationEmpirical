import java.util.Scanner;

public class atcoder_AGC017_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        long combi(int n, int k) {
            long a = 1;
            for (int i = 0; i < k; i++) {
                a *= n - i;
            }
            for (int j = 0; j < k; j++) {
                a /= j + 1;
            }
            return a;
        }

        String[] input2 = scanner.nextLine().split(" ");
        int[] lis = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            lis[i] = Integer.parseInt(input2[i]);
        }

        int[] ls = new int[lis.length];
        for (int a : lis) {
            ls[a % 2]++;
        }
        int one = ls[1];
        int zero = ls[0];

        long patternA = 0;
        long patternB = 0;
        for (int j = 0; j <= zero; j++) {
            patternB += combi(zero, j);
        }

        int time = 0;
        while (time <= one) {
            if (time % 2 == P) {
                patternA += combi(one, time);
            }
            time++;
        }
        System.out.println((int) (patternA * patternB));
    }
}
