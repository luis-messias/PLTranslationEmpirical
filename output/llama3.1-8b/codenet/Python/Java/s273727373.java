import java.util.Scanner;
import java.util.Arrays;

public class s273727373 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] A = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        int[] B = Arrays.copyOf(A, A.length);
        int count = 1;
        for (int i = 0; i < A.length; i++) {
            B[A[i] - 1] = count;
            count++;
        }
        System.out.println(Arrays.toString(B).replaceAll("\\[|\\]", ""));
    }
}