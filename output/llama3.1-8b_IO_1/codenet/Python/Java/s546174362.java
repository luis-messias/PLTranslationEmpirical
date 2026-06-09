import java.util.Arrays;
import java.util.Scanner;

public class s546174362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        String[] input2 = scanner.nextLine().split(" ");
        int A = 0;
        for (String s : input2) {
            A += Integer.parseInt(s);
        }
        int[] array = new int[A];
        int index = 0;
        for (int i = 0; i < A; i++) {
            if (Integer.parseInt(input2[i % input2.length]) > 0) {
                array[index++] = Integer.parseInt(input2[i % input2.length]);
            }
        }

        Arrays.sort(array);

        while (M > 0) {
            array[array.length - 1] /= 2;
            M--;
            int i = array.length - 2;
            while (M > 0 && i >= 0 && array[i] >= array[array.length - 1]) {
                array[i] /= 2;
                M--;
                i--;
            }
            Arrays.sort(array);
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println(sum);
    }
}
