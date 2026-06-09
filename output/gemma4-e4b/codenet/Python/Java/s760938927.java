import java.util.Scanner;

public class s760938927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read h, w, ka
        if (!scanner.hasNextInt()) {
            return;
        }
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int ka = scanner.nextInt();

        // Read the matrix mat
        char[][] mat = new char[h][w];
        for (int i = 0; i < h; i++) {
            String row = scanner.next();
            mat[i] = row.toCharArray();
        }

        long ans = 0;
        
        // Calculate the limit: 2^(h+w)
        // We use long for the loop counter i and the limit to prevent overflow 
        // if h+w is up to 62.
        long limit = 1L << (h + w);

        for (long i = 0; i < limit; i++) {
            // Convert i to binary string of length h+w, padded with leading zeros
            String binaryString = Long.toBinaryString(i);
            
            // Pad the binary string to ensure length h+w
            String b = String.format("%" + (h + w) + "s", binaryString).replace(' ', '0');

            // rs: row constraints (first h bits)
            String rs = b.substring(0, h);
            // cs: column constraints (remaining w bits)
            String cs = b.substring(h, h + w);

            int ct = 0;
            
            // Count the number of '#' cells (l, k) such that rs[l] == '0' and cs[k] == '0'
            for (int l = 0; l < h; l++) {
                for (int k = 0; k < w; k++) {
                    if (mat[l][k] == '#'