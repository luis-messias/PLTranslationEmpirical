import java.util.Scanner;

public class s760938927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int ka = Integer.parseInt(input[2]);

        char[][] mat = new char[h][w];
        for (int i = 0; i < h; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                mat[i][j] = row.charAt(j);
            }
        }

        int ans = 0;
        for (long i = 0; i < Math.pow(2, h + w); i++) {
            String b = Long.toBinaryString(i).replace(" ", "").toUpperCase();
            while (b.length() < h + w) {
                b = "0" + b;
            }
            String rs = b.substring(0, h);
            String cs = b.substring(h);

            int ct = 0;
            for (int l = 0; l < h; l++) {
                for (int k = 0; k < w; k++) {
                    if (mat[l][k] == '#' && rs.charAt(l) == '0' && cs.charAt(k) == '0') {
                        ct++;
                    }
                }
            }

            if (ct == ka) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}