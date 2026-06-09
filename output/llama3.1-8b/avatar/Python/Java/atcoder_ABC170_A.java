import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC170_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        int[] a = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            a[i] = Integer.parseInt(inputArray[i]);
        }
        for (int e = 0; e < a.length; e++) {
            if (a[e] == 0) {
                System.out.println(e + 1);
                break;
            }
        }
    }
}