import java.util.Scanner;

public class codeforces_222_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] elems = new int[n];
        for (int i = 0; i < n; i++) {
            elems[i] = scanner.nextInt();
        }
        
        boolean allSame = true;
        for (int i = 1; i < n; i++) {
            if (elems[i] != elems[0]) {
                allSame = false;
                break;
            }
        }
        
        if (allSame) {
            System.out.println(0);
            return;
        }
        
        if (k == 1) {
            System.out.println(-1);
            return;
        }
        
        boolean allSameFromK = true;
        for (int i = k - 1; i < n; i++) {
            if (elems[i] != elems[k - 1]) {
                allSameFromK = false;
                break;
            }
        }
        
        if (!allSameFromK) {
            System.out.println(-1);
            return;
        }
        
        int target = elems[n - 1];
        int toDelete = 0;
        for (int i = 0; i < k - 1; i++) {
            if (elems[i] != target) {
                toDelete++;
            }
        }
        
        System.out.println(toDelete);
    }
}
