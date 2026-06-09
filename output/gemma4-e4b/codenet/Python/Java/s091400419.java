import java.util.Scanner;
import java.util.Arrays;

public class s091400419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        int[] lst = {a + b, a - b, a * b};
        
        int maxVal = lst[0];
        for (int i = 1; i < lst.length; i++) {
            if (lst[i] > maxVal) {
                maxVal = lst[i];
            }
        }
        
        System.out.println(maxVal);
        scanner.close();
    }
}