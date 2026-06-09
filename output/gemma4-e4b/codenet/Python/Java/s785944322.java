import java.util.Scanner;

public class s785944322 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            if (a >= 13) {
                System.out.println(b);
            } else if (a >= 6) {
                // Integer division in Java
                System.out.println(b / 2);
            } else {
                System.out.println(0);
            }
        }
        
        scanner.close();
    }
}