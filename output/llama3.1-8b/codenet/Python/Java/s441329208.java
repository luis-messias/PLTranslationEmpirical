import java.util.Arrays;
import java.util.Scanner;

public class s441329208 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = Arrays.sort(scanner.nextLine().trim().split("\\s+")).toString();
        String t = Arrays.sort(scanner.nextLine().trim().split("\\s+").reverse()).toString();
        System.out.println((s.compareTo(t) < 0) ? "Yes" : "No");
    }
}