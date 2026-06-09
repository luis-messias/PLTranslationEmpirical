import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class s214672212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        String[] parts = line.split(" ");

        Integer[] nums = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        // Sort in descending order
        Arrays.sort(nums, Collections.reverseOrder());

        // Calculate and print the result (assuming at least 3 elements are present)
        int result = nums[0] * 10 + nums[1] + nums[2];
        System.out.println(result);
    }
}