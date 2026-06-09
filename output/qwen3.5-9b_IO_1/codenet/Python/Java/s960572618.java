import java.util.Scanner;

public class s960572618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().trim().split("\\s+");
        
        if (values[0].equals(values[1]) && values[1].equals(values[2])) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
