import java.util.Arrays;
import java.util.Scanner;

public class s695100304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String input = scanner.next();
        String[] parts = input.split(" ");
        int[] x = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            x[i] = Integer.parseInt(parts[i]);
        }
        reverseArray(x);
        System.out.println(Arrays.toString(x).replaceAll("\\[|\\]", ""));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
