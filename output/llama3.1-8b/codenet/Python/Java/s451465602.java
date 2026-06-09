import java.util.Scanner;

public class s451465602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int h = n / 3600;
        n %= 3600;
        int m = n / 60;
        n %= 60;
        int s = n;
        System.out.println(String.format("%d:%d:%d", h, m, s));
    }
}