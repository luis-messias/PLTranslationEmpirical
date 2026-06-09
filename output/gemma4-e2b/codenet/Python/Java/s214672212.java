import java.util.Arrays;
import java.util.Scanner;

public class s214672212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the line of space-separated integers
        String line = scanner.nextLine();
        
        // Split the line by space and parse integers into an array
        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        
        // Sort the array in reverse order (descending)
        // Arrays.sort sorts ascending, so we use a custom sort or reverse the result.
        // Using a custom sort for descending order:
        Arrays.sort(nums); // Sorts ascending
        
        // Reverse the sorted array to get descending order
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        
        // Calculate the result: nums[0]*10 + nums[1] + nums[2]
        // This assumes there are at least 3 numbers in the input.
        if (nums.length >= 3) {
            long result = (long) nums[0] * 10 + nums[1] + nums[2];
            System.out.println(result);
        }
    }
}