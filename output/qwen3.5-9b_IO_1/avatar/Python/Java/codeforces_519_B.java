import java.util.Scanner;

public class codeforces_519_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        
        int x = 0;
        int y = 0;
        int z = 0;
        
        for (int i = 0; i < n; i++) {
            x += a[i];
        }
        
        for (int i = 0; i < n; i++) {
            y += b[i];
        }
        
        for (int i = 0; i < n; i++) {
            z += c[i];
        }
        
        System.out.println(Math.abs(x - y));
        System.out.println(Math.abs(y - z));
    }
}
