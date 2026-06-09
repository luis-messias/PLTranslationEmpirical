import java.util.Scanner;
import java.util.Arrays;

public class s087080706 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line: n, m, x
        // We read the entire line and split it, assuming the input format matches the Python code's intent.
        // Although n and m are unused, we must read them to consume the input line.
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        
        // n, m, x are read, but we only need x for the logic.
        // int n = Integer.parseInt(parts1[0]);
        // int m = Integer.parseInt(parts1[1]);
        int x = Integer.parseInt(parts1[2]);

        // Read the second line: array a
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        
        int[] a = new int[parts2.length];
        for (int i = 0; i < parts2.length; i++) {
            a[i] = Integer.parseInt(parts2[i]);
        }

        // Equivalent to i = bisect(a, x)
        // bisect_right finds the insertion point i such that all a[:i] <= x and all a[i:] > x.
        int i = Arrays.binarySearch(a, x);
        
        // If x is not found, binarySearch returns -(insertion point) - 1.
        // We need to calculate the insertion point (i) based on the Python bisect behavior.
        if (i < 0) {
            // Insertion point is -(i + 1)
            i = -(i + 1);
        }
        
        // The Python code calculates min(len(a[:i]), len(a[i:])))
        // len(a[:i]) is i
        // len(a[i:]) is a.length - i
        
        int len_a = a.length;
        int len_left = i;
        int len_right = len_a - i;
        
        System.out.println(Math.min(len_left, len_right));
        
        scanner.close();
    }
}