import java.util.Scanner;

public class s025428739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int[] lst = new int[3];
        lst[0] = A + B;
        lst[1] = A - B;
        lst[2] = A * B;

        System.out.println(java.util.Arrays.stream(lst).max().getAsInt());
    }
}