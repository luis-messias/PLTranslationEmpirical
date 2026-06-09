import java.util.Arrays;
import java.util.Scanner;

public class s706119740 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] candy = Arrays.stream(input).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(candy[0] + candy[1] == candy[2] ? "Yes" : "No");
    }
}