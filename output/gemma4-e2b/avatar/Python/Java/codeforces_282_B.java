import java.util.Scanner;

public class codeforces_282_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read firstline
        if (!scanner.hasNextInt()) {
            return;
        }
        int firstline = scanner.nextInt();

        long total = 0;
        StringBuilder memory = new StringBuilder();

        for (int x = 0; x < firstline; x++) {
            // Read A and G from the next line
            if (!scanner.hasNextInt()) {
                break;
            }
            int A = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                break;
            }
            int G = scanner.nextInt();

            if (total + A <= 500) {
                total += A;
                memory.append("A");
            } else {
                total -= G;
                memory.append("G");
            }
        }

        System.out.println(memory.toString());
    }
}