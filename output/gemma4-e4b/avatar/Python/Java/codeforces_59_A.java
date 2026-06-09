import java.util.Scanner;

public class codeforces_59_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        scanner.close();

        int cu = 0;
        int cl = 0;

        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (Character.isLowerCase(c)) {
                cl++;
            } else {
                cu++;
            }
        }

        String out;
        if (cu > cl) {
            out = txt.toUpperCase();
        } else {
            out = txt.toLowerCase();
        }

        System.out.println(out);
    }
}