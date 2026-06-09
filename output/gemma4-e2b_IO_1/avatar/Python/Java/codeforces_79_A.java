import java.util.Scanner;

public class codeforces_79_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read x and y
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int y = scanner.nextInt();

                int a = 0;

                // Loop condition: (x >= 0 and y >= 22) or (x >= 1 and y >= 12) or (x >= 2 and y >= 2)
                while ((x >= 0 && y >= 22) || (x >= 1 && y >= 12) || (x >= 2 && y >= 2)) {
                    if (a == 1) {
                        if (y >= 22) {
                            y -= 22;
                        } else if (x >= 1 && y >= 12) {
                            x -= 1;
                            y -= 12;
                        } else {
                            x -= 2;
                            y -= 2;
                        }
                    } else {
                        if (x >= 2 && y >= 2) {
                            x -= 2;
                            y -= 2;
                        } else if (x >= 1 && y >= 12) {
                            x -= 1;
                            y -= 12;
                        } else {
                            y -= 22;
                        }
                    }
                    a = 1 - a;
                }

                // Output: [ 'Ciel', 'Hanako' ][ 1 - a ]
                String[] names = {"Ciel", "Hanako"};
