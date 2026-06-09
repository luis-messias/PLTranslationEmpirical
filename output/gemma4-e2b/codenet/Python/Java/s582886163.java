import java.util.Scanner;
import java.util.Arrays;

public class s582886163 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read 5 capacities
        int[] capacityList = new int[5];
        for (int i = 0; i < 5; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input might be incomplete, though typically not expected in competitive programming style
                return;
            }
            capacityList[i] = scanner.nextInt();
        }

        // Sort the list
        Arrays.sort(capacityList);

        // Find the bottle neck (the smallest capacity)
        int bottleNeck = capacityList[0];

        // Calculate the result: 4 + ceil(N / bottle_neck)
        // ceil(a / b) is calculated as (a + b - 1) / b using integer division
        int result = 4 + (N + bottleNeck - 1) / bottleNeck;

        System.out.println(result);

        scanner.close();
    }
}