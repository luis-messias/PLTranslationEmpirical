import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC171_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);

        String[] input2 = scanner.nextLine().split(" ");
        int[] numbers = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            numbers[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(numbers);
        int sum = 0;
        for (int i = 0; i < k && i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }
}