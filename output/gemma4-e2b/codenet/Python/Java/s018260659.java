import java.util.Scanner;

public class s018260659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int cnt = 1;
        boolean found = false;

        while (cnt <= 9) {
            if (N % cnt == 0) {
                int quotient = N / cnt;
                if (quotient >= 1 && quotient <= 9) {
                    System.out.println("Yes");
                    found = true;
                    break;
                }
            }
            cnt++;
        }

        if (!found) {
            System.out.println("No");
        }
    }
}