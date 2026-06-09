import java.util.Scanner;

public class codeforces_148_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int princess = Integer.parseInt(scanner.nextLine());
        int dragon = Integer.parseInt(scanner.nextLine());
        int t = Integer.parseInt(scanner.nextLine());
        int f = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        if (dragon <= princess) {
            System.out.println(0);
            return;
        }

        double position = t * princess;
        position += princess * position / (double)(dragon - princess);

        int result = 0;

        while (position < c) {
            result++;
            position += princess * position / dragon;
            position += princess * f;
            position += princess * position / (double)(dragon - princess);
        }

        System.out.println(result);
    }
}