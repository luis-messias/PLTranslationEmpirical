import java.util.Scanner;

public class s960572618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split("\\s+");

        if (parts[0].equals(parts[1]) && parts[1].equals(parts[2])) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}