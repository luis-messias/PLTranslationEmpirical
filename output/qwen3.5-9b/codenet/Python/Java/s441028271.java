import java.util.Scanner;

public class s441028271 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        
        if (k % 2 == 0) {
            System.out.println(a - b);
        } else {
            System.out.println(b - a);
        }
    }
}