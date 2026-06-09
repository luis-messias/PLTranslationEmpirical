import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC070_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        int[] A = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            A[i] = Integer.parseInt(inputArray[i]);
        }
        if ((A[1] <= A[2]) || (A[3] <= A[0])) {
            System.out.println(0);
        } else {
            Arrays.sort(A);
            System.out.println(A[2] - A[1]);
        }
    }
}