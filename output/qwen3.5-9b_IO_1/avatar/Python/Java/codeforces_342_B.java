import java.util.Scanner;

public class codeforces_342_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();
        
        int d = (s < f) ? 1 : -1;
        char c = (s < f) ? 'R' : 'L';
        
        StringBuilder res = new StringBuilder();
        int i = 1;
        int j = s;
        
        int t = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        
        int k = 1;
        
        while (j != f) {
            if (i > t && k < m) {
                t = scanner.nextInt();
                l = scanner.nextInt();
                r = scanner.nextInt();
                k++;
            }
            if (i == t && (l <= j && j <= r || l <= j + d && j + d <= r)) {
                res.append('X');
            } else {
                res.append(c);
                j += d;
            }
            i++;
        }
        
        System.out.println(res.toString());
    }
}
