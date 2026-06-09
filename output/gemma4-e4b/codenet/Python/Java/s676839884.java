import java.util.Scanner;

public class s676839884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        if (t.length() > 0 && t.charAt(t.length() - 1) != ' ') {
            String tMinusLastChar = t.substring(0, t.length() - 1);
            if (tMinusLastChar.equals(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            // Handle case where t might be empty or only whitespace, 
            // though the original Python logic handles this implicitly.
            // If t is empty, t[:-1] is an empty string.
            if (t.isEmpty() && s.isEmpty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scanner.close();
    }
}