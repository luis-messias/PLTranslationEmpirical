import java.util.Scanner;

public class codeforces_334_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;
        int j = (int) Math.pow(n, 2);

        while (i < j) {
            System.out.println(i + " " + (j - 1));
            i += 2;
            j -= 2;
        }
    }
}
