import java.util.Scanner;

public class codeforces_148_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long princess = scanner.nextLong();
        long dragon = scanner.nextLong();
        long t = scanner.nextLong();
        long f = scanner.nextLong();
        long c = scanner.nextLong();
        
        if (dragon <= princess) {
            System.out.println(0);
            System.exit(0);
        }
        
        long result = 0;
        long position = t * princess;
        position += princess * position / (dragon - princess);
        
        while (position < c) {
            result += 1;
            position += princess * position / dragon;
            position += princess * f;
            position += princess * position / (dragon - princess);
        }
        
        System.out.println(result);
    }
}