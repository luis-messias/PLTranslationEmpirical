import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class s735480710 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String[] a = scanner.nextLine().split("\\s+");
        
        ArrayList<String> oddElements = new ArrayList<>();
        ArrayList<String> evenElements = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenElements.add(a[i]);
            } else {
                oddElements.add(a[i]);
            }
        }
        
        Collections.reverse(oddElements);
        oddElements.addAll(evenElements);
        
        ArrayList<String> b = new ArrayList<>(oddElements);
        
        if (n % 2 == 0) {
            System.out.println(String.join(" ", b));
        } else {
            Collections.reverse(b);
            System.out.println(String.join(" ", b));
        }
    }
}
