import java.util.Scanner;
import java.util.Arrays;

public class codeforces_25_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] list = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            list[i] = Integer.parseInt(input[i]) % 2;
        }
        if (Arrays.stream(list).sum() == 1) {
            System.out.println(Arrays.asList(list).indexOf(1) + 1);
        } else {
            System.out.println(Arrays.asList(list).indexOf(0) + 1);
        }
    }
}