import java.util.Arrays;
import java.util.Scanner;

public class codeforces_459_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list l1 (assuming n elements follow)
        Integer[] l1 = new Integer[n];
        for (int i = 0; i < n; i++) {
