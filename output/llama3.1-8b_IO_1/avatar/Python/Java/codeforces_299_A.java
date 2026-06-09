import java.util.Arrays;
import java.util.Scanner;

public class codeforces_299_A {
    public static int numInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] arrInput() {
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");
        int[] array = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            array[i] = Integer.parseInt(splitInput[i]);
        }
        return array;
    }

    public static int[] spInput() {
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");
        int[] array = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            array[i] = Integer.parseInt(splitInput[i]);
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).min().getAsInt();
        System.out.println(a == 1 || any(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(), a) ? a : -1);
    }

    public static boolean any(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % n != 0) {
                return true;
            }
        }
        return false;
    }
}
