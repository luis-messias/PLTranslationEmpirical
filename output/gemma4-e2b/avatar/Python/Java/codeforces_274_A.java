import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_274_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line: num and k
        // The Python code reads num and k from the first input line.
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        
        if (parts1.length < 2) return;
        // num is read but not used in the logic, k is used.
        // int num = Integer.parseInt(parts1[0]); 
        int k = Integer.parseInt(parts1[1]);

        // Read the second line: arr
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        
        int[] arr = new int[parts2.length];
        for (int i = 0; i < parts2.length; i++) {
            arr[i] = Integer.parseInt(parts2[i]);
        }

        // Equivalent to different = set()
        Set<Integer> different = new HashSet<>();
        // Equivalent to temp = 0
        int temp = 0;

        // Equivalent to arr.sort()
        Arrays.sort(arr);

        // Equivalent to the loop
        for (int x : arr) {
            // Python condition: if ( x % k != 0 or not x // k in different ) :
            // Note: Python's // is floor division, which is standard integer division in Java for positive numbers.
            // We must handle the case where x/k is calculated.
            
            boolean condition = (x % k != 0) || (!different.contains(x / k));
            
            if (condition) {
                different.add(x);
            }
            
            // Equivalent to temp = max(len(different), temp)
            temp = Math.max(different.size(), temp);
        }

        // Equivalent to print(temp)
        System.out.println(temp);
        
        scanner.close();
    }
}