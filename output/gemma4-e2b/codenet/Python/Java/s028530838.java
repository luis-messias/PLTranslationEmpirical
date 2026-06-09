import java.util.Scanner;

public class s028530838 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();

        // Check if the entire string is lowercase (equivalent to Python's x.islower())
        if (x.toLowerCase().equals(x)) {
            System.out.println("a");
        } else {
            System.out.println("A");
        }
    }
}