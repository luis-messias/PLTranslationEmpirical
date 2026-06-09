import java.util.Scanner;

public class s702834515 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int r = 0;
        for (int i = 1; i <= n; i++) {
            if ((i % 3 != 0) && (i % 5 != 0)) {
                r += i;
            }
        }
        System.out.println(r);
    }
}