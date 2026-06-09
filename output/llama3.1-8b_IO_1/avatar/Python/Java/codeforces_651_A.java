import java.util.Scanner;
import java.util.Arrays;

public class codeforces_651_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        System.out.println(Math.max(x + y - 3 + ((y - x) % 3 > 0 ? 1 : 0), 0));

        Scanner numScanner = new Scanner(System.in);
        String numInput = numScanner.nextLine();
        int num = Integer.parseInt(numInput);

        Scanner arrScanner = new Scanner(System.in);
        String[] arrInput = arrScanner.nextLine().split(" ");
        int[] arr = new int[arrInput.length];
        for (int i = 0; i < arrInput.length; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        Scanner spScanner = new Scanner(System.in);
        String[] spInput = spScanner.nextLine().split(" ");
        int[] sp = new int[spInput.length];
        for (int i = 0; i < spInput.length; i++) {
            sp[i] = Integer.parseInt(spInput[i]);
        }

        String str = scanner.nextLine();
    }
}
