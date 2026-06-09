import java.util.Scanner;
import java.util.stream.IntStream;

public class atcoder_ABC122_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        String s = scanner.next();

        int[][] problems = new int[q][2];
        for (int i = 0; i < q; i++) {
            problems[i][0] = scanner.nextInt();
            problems[i][1] = scanner.nextInt();
        }

        int[] cumsum = IntStream.range(0, n)
                .map(i -> (i == 0 ? 0 : (s.substring(Math.max(0, i - 1), Math.min(n, i + 2)).equals("AC") ? 1 : 0)) + (i == 0 ? 0 : cumsum[i - 1]))
                .toArray();

        for (int[] problem : problems) {
            System.out.println(cumsum[problem[1] - 1] - (cumsum[problem[0] - 2]));
        }
    }
}
