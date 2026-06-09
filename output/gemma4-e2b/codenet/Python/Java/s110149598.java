import java.util.Scanner;

public class s110149598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        String a = parts[0];
        String b = parts[1];
        
        if (a.compareTo(b) < 0) {
            System.out.println("<");
        } else if (a.compareTo(b) > 0) {
            System.out.println(">");
        } else {
            System.out.println("=");
        }
        
        scanner.close();
    }
}