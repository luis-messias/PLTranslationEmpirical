import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_421_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n, a, b (These are read but only n is used in the logic)
        // We read the first line to get n, a, b
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        
        if (parts1.length >= 3) {
            // int n = Integer.parseInt(parts1[0]); // n is the size of the loop
            // int a = Integer.parseInt(parts1[1]);
            // int b = Integer.parseInt(parts1[2]);
        }

        // Read lista
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        List<Integer> lista = new ArrayList<>();
        for (String s : parts2) {
            if (!s.isEmpty()) {
                lista.add(Integer.parseInt(s));
            }
        }

        // Read listb
        if (!scanner.hasNextLine()) return;
        String line3 = scanner.nextLine();
        String[] parts3 = line3.split(" ");
        List<Integer> listb = new ArrayList<>();
        for (String s : parts3) {
            if (!s.isEmpty()) {
                listb.add(Integer.parseInt(s));
            }
        }

        // Logic: Iterate k from 0 to n-1
        // Since n was read from the first line, we use