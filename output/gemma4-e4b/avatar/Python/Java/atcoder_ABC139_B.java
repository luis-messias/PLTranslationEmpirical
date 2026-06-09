import java.util.Scanner;

public class atcoder_ABC139_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Assuming input is provided as two space-separated integers
        if (!scanner.hasNextInt()) {
            return;
        }
        int a = scanner.nextInt();
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int b = scanner.nextInt();
        
        scanner.close();

        int hole = 1;
        int i = 0;
        boolean check = true;

        while (check) {
            if (hole >= b) {
                check = false;
            } else {
                // hole = a * ( i + 1 ) - i
                hole = a * (i + 1) - i;
                i++;
            }
        }
        System.out.println(i);
    }
}