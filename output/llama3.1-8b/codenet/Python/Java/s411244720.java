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
            String[] AInput = scanner.nextLine().split(" ");
            int[] A = new int[AInput.length];
            for (int j = 0; j < AInput.length; j++) {
                A[j] = Integer.parseInt(AInput[j]);
            }
            S.addAll(Arrays.asList(A));
        }

        System.out.println(N - S.size());
    }
}