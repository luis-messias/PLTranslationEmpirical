import java.util.Scanner;

public class codeforces_387_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first line (h1:m1)
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(":");
        int h1 = Integer.parseInt(parts1[0]);
        int m1 = Integer.parseInt(parts1[1]);

        // Read second line (h2:m2)
        String line2 = scanner.nextLine();