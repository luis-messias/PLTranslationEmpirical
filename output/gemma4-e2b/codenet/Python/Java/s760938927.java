import java.util.Scanner;

public class s760938927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read h, w, ka
        if (!scanner.hasNextInt()) return;
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int ka = scanner.nextInt();

        // Read the matrix mat
        String[] mat = new String[h];
        for (int i = 0; i < h; i++) {
            mat[i] = scanner.next();
        }

        long ans = 0;
        int totalLength = h + w;

        // Iterate through all numbers i from 0 to 2^(h+w) - 1
        // The loop runs up to 2^(h+w)
        for (int i = 0; i < (1 << totalLength); i++) {
            // Convert i to a binary string of length h+w
            String b = Integer.toBinaryString(i);
            // Pad with leading zeros to ensure length h+w
            String fullB = String.format("%" + totalLength + "s", b).replace(' ', '0');

            // Extract rs (first h bits) and cs (last w bits)
            String rs = fullB.substring(0, h);
            String cs = fullB.substring(h, totalLength);

            int ct = 0;
            // Check the condition
            for (int l = 0; l < h; l++) {
                for (int k = 0; k < w; k++) {
                    // Check if mat[l][k] is '#'
                    // Check if rs[l] is '0'
                    // Check if cs[k] is '0'
                    if (mat[l].charAt(k) == '#' && rs.charAt(l) == '0' && cs.charAt(k) == '0') {
                        ct++;
                    }
                }
            }

            if (ct == ka) {
                ans++;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}