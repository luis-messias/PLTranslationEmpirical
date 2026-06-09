import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class s683277023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        // Read the list li
        String[] liStr = scanner.nextLine().split(" ");
        int[] li = new int[n];
        for (int i = 0; i < n; i++) {
            li[i] = Integer.parseInt(liStr[i]);
        }

        // Sort the array
        Arrays.sort(li);

        // Calculate the sum of the first k elements
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += li[i];
        }

        System.out.println(sum);
    }
}