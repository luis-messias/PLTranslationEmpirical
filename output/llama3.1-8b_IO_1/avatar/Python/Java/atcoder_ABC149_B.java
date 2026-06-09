import java.util.Scanner;

public class atcoder_ABC149_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] cookiesStr = input.split(" ");
        int[] cookies = new int[cookiesStr.length];
        for (int i = 0; i < cookiesStr.length; i++) {
            try {
                cookies[i] = Integer.parseInt(cookiesStr[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
        }
        int leftOver = cookies[0] - cookies[2];
        int takahashi = Math.max(0, leftOver);
        System.out.println(takahashi + " " + (takahashi > 0 ? String.valueOf(cookies[1]) : String.valueOf(Math.max(0, cookies[1] - Math.abs(leftOver))));
    }
}
