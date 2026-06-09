import java.util.Scanner;

public class codeforces_67_B {
    public static void main(String[] args) {
        Scanner u = new Scanner(System.in);
        int n = u.nextInt();
        int k = u.nextInt();
        int[] M = new int[n];
        for (int i = 0; i < n; i++) {
            M[i] = u.nextInt();
        }
        
        for (int j = 0; j < n; j++) {
            int p = -1;
            for (int i = 0; i < n; i++) {
                if (M[i] == 0) {
                    p = i;
                    break;
                }
            }
            if (p != -1) {
                System.out.print((p + 1) + " ");
                for (int l = 0; l < p + 1 - k; l++) {
                    M[l] -= 1;
                }
                M[p] -= 1;
            }
        }
    }
}