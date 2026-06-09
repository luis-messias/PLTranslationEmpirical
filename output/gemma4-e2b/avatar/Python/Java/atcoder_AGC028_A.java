import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class atcoder_AGC028_A {

    static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int M = scanner.nextInt();

        // Read S and T
        String S = scanner.next();
        String T = scanner.next();

        List<Character> listS = new ArrayList<>();
        for (char c : S.toCharArray()) {
            listS.add(c);
        }

        List<Character> listT = new ArrayList<>();
        for (char c : T.toCharArray()) {
            listT.add(c);
        }

        // Number_i = [0, 1, ..., N-1]
        // Number_j = [0, 1, ..., M-1]

        // Number_iMN = [ i * M / N for i in range(N) ]
        List<Double> Number_iMN = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Number_iMN.add((double) i * M / N);
        }

        // Number_j = [0, 1, ..., M-1]
        List<Integer> Number_j = new ArrayList<>();
        for (int j = 0; j