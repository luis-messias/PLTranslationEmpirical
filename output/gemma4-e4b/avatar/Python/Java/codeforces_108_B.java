import java.util.Arrays;
import java.util.Scanner;

public class codeforces_108_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            System.out.println("NO");
            return;
        }
        
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            System.out.println("NO");
            return;
        }

        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }
        
        Arrays.sort(a);
        
        boolean found = false;
        for (int i = 1; i < a.length; i++) {
            // Check the condition: a[i] != a[i - 1] AND a[i] < a[i - 1] * 2
            if (a[i] != a[i - 1] && a[i] < a[i - 1] * 2) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}