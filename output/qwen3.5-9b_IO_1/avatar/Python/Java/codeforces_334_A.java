import java.util.Scanner;

public class codeforces_334_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;
        int j = n * n;
        int count = 0;
        while (i < j) {
            System.out.print(i + " " + j + " ");
            i++;
            j--;
            count++;
            if (count % 2 == 0) {
                System.out.println();
            }
        }
    }
}
