import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC123_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read x, y, z, k from the first line
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        
        if (parts1.length < 4) return;
        
        int x = Integer.parseInt(parts1[0]);
        int y = Integer.parseInt(parts1[1]);
        int z = Integer.parseInt(parts1[2]);
        int k = Integer.parseInt(parts1[3]);

        // Read a
        List<Integer> a = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line2 = scanner.nextLine();
            String[] parts2 = line2.split(" ");
            for (String part : parts2) {
                if (!part.isEmpty()) {
                    a.add(Integer.parseInt(part));
                }
            }
        }

        // Read b
        List<Integer> b = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line3 = scanner.nextLine();
            String[] parts3 = line3.split(" ");
            for (String part : parts3) {
                if (!part.isEmpty()) {
                    b.add(Integer.parseInt(part));
                }
            }
        }

        // Read c
        List<Integer> c = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String
