import java.util.Scanner;
import java.util.Arrays;

public class s052231578 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Define the array
        int[] arr = {111, 222, 333, 444, 555, 666, 777, 888, 999};

        // Equivalent to bisect_left(arr, N). 
        // Arrays.binarySearch returns the index if found, or (-(insertion point) - 1) if not found.
        // The insertion point is the index of the first element greater than or equal to the key, 
        // which is exactly what bisect_left finds.
        int ans_idx = Arrays.binarySearch(arr, N);

        if (ans_idx >= 0) {
            // N was found exactly
            System.out.println(arr[ans_idx]);
        } else {
            // N was not found. Calculate the insertion point (bisect_left behavior).
            // insertionPoint = -(ans_idx + 1)
            int insertionPoint = -(ans_idx + 1);
            
            // Ensure the index is within bounds (this handles cases where N > 999, though context implies N <= 999)
            if (insertionPoint < arr.length) {
                System.out.println(arr[insertionPoint]);
            }
            // If N > 999, the behavior of the Python code implies ans_idx would be 9, leading to an error. 
            // Assuming valid inputs based on the Python context, we proceed with the calculated index.
        }
    }
}