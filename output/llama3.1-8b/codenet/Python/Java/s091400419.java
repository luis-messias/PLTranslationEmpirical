import java.util.Scanner;

public class s091400419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int[] lst = new int[3];
        lst[0] = a + b;
        lst[1] = a - b;
        lst[2] = a * b;

        System.out.println(java.util.Arrays.stream(lst).max().getAsInt());
    }
}