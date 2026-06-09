import java.util.Scanner;

public class s018260659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        boolean found = false;

        for (int cnt = 1; cnt <= 9; cnt++) {
            if (N % cnt == 0) {
                int quotient = N / cnt;
                if (quotient >= 1 && quotient <= 9) {
                    System.out.println("Yes");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No");
        }
    }
}