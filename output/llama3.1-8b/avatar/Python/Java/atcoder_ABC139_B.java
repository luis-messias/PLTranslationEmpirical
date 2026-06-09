import java.util.Scanner;

public class atcoder_ABC139_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int hole = 1;
        int i = 0;
        boolean check = true;

        while (check) {
            if (hole >= b) {
                check = false;
            } else {
                hole = a * (i + 1) - i;
                i++;
            }
        }

        System.out.println(i);
    }
}