import java.util.*;

public class s411244720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Set<Integer> S = new HashSet<>();

        for (int i = 0; i < K; i++) {
            int d = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            String[] AInput = scanner.nextLine().split(" ");
            for (String s : AInput) {
                S.add(Integer.parseInt(s));
            }
        }

        System.out.println(N - S.size());
    }
}
