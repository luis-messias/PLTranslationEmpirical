import java.util.Scanner;

public class s110149598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (Integer.parseInt(input[0]) < Integer.parseInt(input[1])) {
            System.out.println("<");
        } else if (Integer.parseInt(input[0]) > Integer.parseInt(input[1])) {
            System.out.println(">");
        } else {
            System.out.println("=");
        }
    }
}