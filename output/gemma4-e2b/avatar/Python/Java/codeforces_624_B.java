import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class codeforces_624_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read array A
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                a[i] = scanner.nextInt();
            }
        }

        // Sort A in reverse order (descending)
        Arrays.sort(a);
        // Reverse the sort to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }
        // Alternatively, use Collections.reverseOrder() if using List, but array manipulation is fine.
        // A simpler way for arrays is to use a custom comparator or sort and reverse if we were using List.
        // Since we are using an array, let's ensure the sort is descending.
        // Arrays.sort(a); // Sorts ascending
        // for (int i = 0; i < n; i++) {
        //     int temp = a[i];
        //     a[i] = a[n - 1 - i];
        //     a[n - 1 - i] = temp;
        // }


        // Re-sorting using Collections.reverse for simplicity and correctness if we treat it as a list conceptually
        // Since we are using an array, let's just use the standard sort and reverse the logic if needed, 
        // or ensure the array is sorted descendingly.
        
        // Let's re-sort the array explicitly in descending order:
        Arrays.sort(a); // Sorts ascending
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }


        // Initialize variables
        // pre corresponds to float('inf'), we use a large integer or handle the logic carefully.
        // Since the calculation involves pre - 1, and we are dealing with array elements, 
        // we can initialize pre to a value larger than any possible element (e.g., Integer.MAX_VALUE)
        // or handle the first iteration specially.
        
        // Python used float('inf'). In Java, we use a very large number or handle the first step.
        // Since the first calculation involves pre - 1, initializing pre to a large value works.
        long pre = Long.MAX_VALUE; 
        long ans = 0;

        for (int j = 0; j < n; j++) {
            long current_a = a[j];
            
            // Python: ans += max(0, min(pre - 1, a[j]))
            long term = Math.min(pre - 1, current_a);
            ans += Math.max(0, term);
            
            // Python: pre = max(0, min(pre - 1, a[j]))
            pre = Math.max(0, term);
        }

        System.out.println(