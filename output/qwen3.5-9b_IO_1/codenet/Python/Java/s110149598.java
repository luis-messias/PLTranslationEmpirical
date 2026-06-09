import java.util.Scanner;

public class s110149598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        
        if (a.compareTo(b) < 0) {
            System.out.println("<");
        } else if (a.compareTo(b) > 0) {
            System.out.println(">");
        } else {
            System.out.println("=");
        }
    }
}
