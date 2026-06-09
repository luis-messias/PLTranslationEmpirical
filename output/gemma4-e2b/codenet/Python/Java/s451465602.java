import java.util.Scanner;

public class s451465602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n
        int n = scanner.nextInt();

        // Calculate hours
        int h = n / 3600;
        n %= 3600;

        // Calculate minutes
        int m = n / 60;
        n %= 60;

        // Calculate seconds
        int s = n;

        // Print result
        System.out.println(h + ":" + m + ":" + s);
    }
}