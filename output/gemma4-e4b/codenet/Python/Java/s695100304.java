import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class s695100304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        
        // Reversing the array elements and printing them
        // Since Java arrays are fixed size, we can't use Collections.reverse directly.
        // We will print them in reverse order manually.
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(x[i] + (i == 0 ? "" : " "));
        }
        System.out.println();
    }
}