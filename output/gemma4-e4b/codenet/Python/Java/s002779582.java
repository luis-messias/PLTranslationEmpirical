import java.util.Scanner;

public class s002779582 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        
        // Read the list Hs
        int[] Hs = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                N = i;
                Hs = new int[N];
                break;
            }
            Hs[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        int ans = 0;
        int maxH = 0;
        
        for (int H : Hs) {
            if (maxH <= H) {
                ans++;
                maxH = H;
            }
        }
        
        System.out.println(ans);
    }
}