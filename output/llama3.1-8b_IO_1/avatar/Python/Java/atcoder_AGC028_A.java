import java.util.Scanner;
import java.util.Set;

public class atcoder_AGC028_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String S = scanner.next();
        String T = scanner.next();

        char[] listS = S.toCharArray();
        char[] listT = T.toCharArray();

        int[] Number_i = new int[N];
        for (int i = 0; i < N; i++) {
            Number_i[i] = i;
        }

        double[] Number_iMN = new double[N];
        for (int i = 0; i < N; i++) {
            Number_iMN[i] = (double) i * M / N;
        }

        int[] Number_j = new int[M];
        for (int j = 0; j < M; j++) {
            Number_j[j] = j;
        }

        Set<Double> setNumber_iMN = Set.copyOf(Arrays.asList(Number_iMN));
        Set<Integer> setNumber_j = Set.copyOf(Arrays.asList(Number_j));

        double[] Kaburi_j = new double[setNumber_iMN.size()];
        int index = 0;
        for (double num : setNumber_iMN) {
            if (setNumber_j.contains((int) num)) {
                Kaburi_j[index++] = num;
            }
        }

        int[] Kaburi_i = new int[Kaburi_j.length];
        for (int j = 0; j < Kaburi_j.length; j++) {
            Kaburi_i[j] = (int) Math.round(Kaburi_j[j] * N / M);
        }

        boolean Flag = false;
        int counter = 0;
        int Kaburi_Size = Kaburi_i.length;
        while (counter <= Kaburi_Size - 1) {
            if (listS[Kaburi_i[counter]] == listT[(int) Math.round(Kaburi_j[counter])]) {
                counter++;
            } else {
                Flag = true;
                break;
            }
        }

        int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        if (Flag) {
            System.out.println(-1);
        } else {
            System.out.println(N * M / gcd(N, M));
        }
    }
}
