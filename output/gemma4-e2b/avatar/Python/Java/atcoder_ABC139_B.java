import java.util.Scanner;

public class atcoder_ABC139_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read a and b from input
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();

                int hole = 1;
                int i = 0;
                boolean check = true;

                while (check) {
                    if (hole >= b) {
                        check = false;
                    } else {
                        // hole = a * (i + 1) - i
                        hole = a * (i + 1) - i;
                        i += 1;
                    }
                }
                
                System.out.println(i);
            }
        }
        
        scanner.close();
    }
}