import java.util.Scanner;

public class codeforces_313_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String soz = scanner.next();
        int[] a = new int[soz.length() + 1];
        
        for (int i = 1; i < soz.length(); i++) {
            a[i] = a[i - 1];
            if (soz.charAt(i - 1) == soz.charAt(i)) {
                a[i] += 1;
            }
        }
        
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int l = scanner.nextInt();
            System.out.println(a[l - 1] - a[m - 1]);
        }
    }
}
