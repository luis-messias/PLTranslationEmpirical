import java.util.Scanner;

public class s759547301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.equals("Sunny")) {
            System.out.println("Cloudy");
        }

        if (s.equals("Cloudy")) {
            System.out.println("Rainy");
        }

        if (s.equals("Rainy")) {
            System.out.println("Sunny");
        }
    }
}