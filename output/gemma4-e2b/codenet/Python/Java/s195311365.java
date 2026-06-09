import java.util.Scanner;

public class s195311365 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() == 2) {
            System.out.println(s);
        } else {
            // Reverse the string
            String reversedS = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                reversedS += s.charAt(i);
            }
            System.out.println(reversedS);
        }
    }
}