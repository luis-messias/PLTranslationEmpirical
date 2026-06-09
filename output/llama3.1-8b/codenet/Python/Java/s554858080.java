import java.util.Arrays;
import java.util.Scanner;

public class s554858080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String num = String.join("", Arrays.stream(input).map(String::valueOf).toArray(String[]::new));

        if (Integer.parseInt(num) % 4 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}