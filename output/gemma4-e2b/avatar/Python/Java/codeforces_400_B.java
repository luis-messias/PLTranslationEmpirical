import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class codeforces_400_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        // int m = scanner.nextInt(); // m is unused

        // Read n subsequent lines and calculate the set c
        Set<Integer> c = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                int indexS = s.indexOf("S");
                int indexG