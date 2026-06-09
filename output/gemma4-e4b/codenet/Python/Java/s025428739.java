import java.util.Scanner;
import java.util.Arrays;

public class s025428739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);

        long[] lst = {
            (long)A + B,
            (long)A - B,
            (long)A * B
        };

        long maxVal = lst[0];
        for (int i = 1; i < lst.length; i++) {
            if (lst[i] > maxVal) {
                maxVal = lst[i];
            }
        }
        System.out.println(maxVal);
    }
}