import java.util.Scanner;

public class s676839884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        if (t.length() > 0) {
            String t_minus_last = t.substring(0, t.length() - 1);
            if (t_minus_last.equals(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            // If t is empty, t[:-1] is an error in Python slicing context, 
            // but logically, if t is empty, the condition fails unless s is also empty.
            System.out.println("No");
        }
    }
}