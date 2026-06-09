import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_134_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read W array
        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLong()) {
                return;
            }
            w[i]
