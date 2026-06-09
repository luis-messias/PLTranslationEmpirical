import java.util.Scanner;

public class s652791025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int num = n.charAt(n.length() - 1) - '0';
        
        if (num == 2 || num == 4 || num == 5 || num == 7 || num == 9) {
            System.out.println("hon");
        } else if (num == 0 || num == 1 || num == 6 || num == 8) {
            System.out.println("pon");
        } else {
            System.out.println("bon");
        }
    }
}
