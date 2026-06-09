import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_108_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Integer> list = new ArrayList<>();
        // Read all integers from the input stream
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        
        if (list.isEmpty()) {
            System.out.println("NO");
            return;
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        
        Arrays.sort(a);
        
        boolean found = false;
        for (int i = 1; i < a.length; i++) {
            // Check the condition: a[i] != a[i - 1] AND a[i] < a[i - 1] * 2
            // Note: Since a[i] and a[i-1] are integers, the multiplication a[i-1] * 2 
            // might overflow if the numbers were extremely large, but for standard integer
