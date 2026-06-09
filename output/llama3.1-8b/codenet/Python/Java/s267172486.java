import java.util.Scanner;

public class s267172486 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);

        int ans = h / a;
        int ama = h % a;

        if (ama != 0) {
            ans += 1;
        }
        System.out.println(ans);
    }
}