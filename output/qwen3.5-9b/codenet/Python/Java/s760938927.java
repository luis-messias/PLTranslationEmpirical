import java.util.Scanner;

public class s760938927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int ka = sc.nextInt();
        
        char[][] mat = new char[h][w];
        for (int i = 0; i < h; i++) {
            String row = sc.next();
            for (int j = 0; j < w; j++) {
                mat[i][j] = row.charAt(j);
            }
        }
        
        int ans = 0;
        int total = 1 << (h + w);
        
        for (int i = 0; i < total; i++) {
            String b = Integer.toBinaryString(i);
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