import java.util.Arrays;
import java.util.Scanner;

public class s441329208 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine().trim();
        String line2 = scanner.nextLine().trim();
        String[] a = line1.split("\\s+");
        String[] b = line2.split("\\s+");
        Arrays.sort(a);
        Arrays.sort(b);
        StringBuilder sbA = new StringBuilder(new String(a));
        StringBuilder sbB = new StringBuilder(new String(b)).reverse();
        System.out.println((sbA.toString().compareTo(sbB.toString()) < 0) ? "Yes" : "No");
    }
}
