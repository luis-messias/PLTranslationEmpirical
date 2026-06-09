import java.util.Arrays;
import java.util.Scanner;

public class s763097776 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] pStr = scanner.nextLine().split(" ");
        int[] p = new int[pStr.length];
        for (int i = 0; i < pStr.length; i++) {
            p[i] = Integer.parseInt(pStr[i]);
        }
        int[] pCopy = Arrays.copyOf(p, p.length);

        Arrays.sort(p);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != pCopy[i]) {
                count++;
            }
        }

        if (count == 0 || count == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}