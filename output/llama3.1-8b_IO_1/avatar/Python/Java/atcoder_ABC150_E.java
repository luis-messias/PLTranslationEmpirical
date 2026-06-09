import java.util.Scanner;

public class atcoder_ABC150_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = 0;
        while (scanner.hasNextLong()) {
            sum += scanner.nextLong();
        }
        System.out.println(sum % 10 == 9 ? "YES" : "NO");
    }
}
