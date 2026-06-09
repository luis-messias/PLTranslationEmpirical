import java.util.Scanner;

public class s642705424 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        int x = 1;
        for (int i = 0; i < N - 1; i++) {
            if (!S.substring(i, i + 1).equals(S.substring(i + 1, i + 2))) {
                x++;
            }
        }
        System.out.println(x);
    }
}