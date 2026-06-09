import java.util.Scanner;

public class atcoder_ABC162_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        
        int rNum = 0;
        int gNum = 0;
        int bNum = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'R') rNum++;
            else if (c == 'G') gNum++;
            else if (c == 'B') bNum++;
        }
        
        int sum = 0;
        for (int step = 1; step <= (N + 1) / 2; step++) {
            for (int i = 0; i < N - 2 * step; i++) {
                String s = "" + S.charAt(i) + S.charAt(i + step) + S.charAt(i + step * 2);
                if (s.equals("RGB") || s.equals("RBG") || s.equals("BGR") || s.equals("BRG") || s.equals("GBR") || s.equals("GRB")) {
                    sum++;
                }
            }
        }
        
        System.out.println(rNum * gNum * bNum - sum);
    }
}
