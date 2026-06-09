import java.util.Arrays;
import java.util.Scanner;

public class s546174362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int A = scanner.nextInt();

        int[] array = {A};
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