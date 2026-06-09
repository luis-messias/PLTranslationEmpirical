import java.util.Scanner;

public class s331817031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read H and W
        if (!scanner.hasNextInt()) return;
        int h = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int w = scanner.nextInt();

        // Read the grid L (H rows)
        String[][] l = new String[h][w];
        for (int i = 0; i < h; i++) {
            if (scanner.hasNextLine()) {
                // Read the row string
                String row = scanner.nextLine();
                // Ensure we only take the first W characters if the input line is longer, 
                // although typically input lines match W.
                l[i] = row.substring(0, Math.
