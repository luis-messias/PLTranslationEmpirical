import java.util.Scanner;

public class s028530838 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        if (x.chars().allMatch(Character::isLowerCase)) {
            System.out.println("a");
        } else {
            System.out.println("A");
        }
    }
}
