import java.util.Scanner;

public class s110149598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input[0].compareTo(input[1]) < 0) {
            System.out.println("<");
        } else if (input[0].compareTo(input[1]) > 0) {
            System.out.println(">");
        } else {
            System.out.println("=");
        }
    }
}
