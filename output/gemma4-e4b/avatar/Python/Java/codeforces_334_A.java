import java.util.Scanner;

public class codeforces_334_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n from standard input
        int n = scanner.nextInt();
        scanner.close();

        int i = 1;
        int j = n * n;

        while (i < j) {
            // Print i and j separated by a space, followed by a newline
            System.out.println(i + " " + j);
            
            i++;
            j--;
        }
    }
}