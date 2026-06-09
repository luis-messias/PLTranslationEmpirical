import java.util.Scanner;
import java.util.Arrays;

public class codeforces_189_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        if (parts.length < 4) {
            // Handle case where not enough numbers are provided, though the Python code implies 4 numbers are expected.
            scanner.close();
            return;
        }

        // Parse input into an array of integers
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // Python logic translation
        int length = arr[0];
        
        // arr = sorted(arr[1:4], reverse=False)
        // We need to sort the subarray from index 1 up to (but not including) index 4.
        // In Java, we extract the relevant part, sort it, and potentially update the array if needed, 
        // but since the Python code reassigns arr, we treat the sorted result as the new state of the relevant elements.
        
        // Extract the slice to sort: arr[1], arr[2], arr[3]
        int[] middle = new int[3];
        System.arraycopy(arr, 1, middle, 0, 3);
        Arrays.sort(middle);
        
        // Update arr[1], arr[2], arr[3] with the sorted values
        arr[1] = middle[0];
        arr[2] = middle[1];
        arr[3] = middle[2];


        if (length % arr[0] == 0) {
            System.out.println(length / arr[0]);
            return;
        }

        int ans = 0;
        
        if (arr[0] == arr[1]) {
            int k = 0;
            // arr[2] is the divisor used in the loop
            int divisor2 = arr[2];
            
            // Loop for i in range(int(length / arr[2]) + 1)
            for (int i = 0; i <= length / divisor2; i++) {
                int check = length - i * divisor2;
                if (check >= 0 && check % arr[0] == 0) {
                    int k_val = check / arr[0];
                    ans = Math.max(ans, k_val + i);
                }
            }
        } else {
            // arr[1] is the divisor used in the inner loop
            int divisor1 = arr[1];
            int divisor2 = arr[2];
            
            // Loop for i in range(int(length / arr[2]) + 1)
            for (int i = 0; i <= length / divisor2; i++) {
                // Loop for j in range(int(length / arr[1]) + 1)
                for (int j = 0; j <= length / divisor1; j++) {
                    int check = length - i * divisor2 - j * divisor1;
                    if (check >= 0 && check % arr[0] == 0) {
                        int k_val = check / arr[0];
                        ans = Math.max(ans, k_val + i + j);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}