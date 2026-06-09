import java.util.Arrays;
import java.util.Scanner;

public class s582886163 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        int N = scanner.nextInt();

        // Read 5 capacities
        int[] capacityList = new int[5];
        for (int i = 0; i < 5; i++) {
            capacityList[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(capacityList);

        // The bottle neck is the smallest capacity
        int bottleNeck = capacityList[0];

        // Calculate 4 + ceil(N / bottleNeck)
        // Using integer arithmetic for ceiling division: (N + D - 1) / D
        int result = 4 + (N + bottleNeck - 1) / bottleNeck;

        System.out.println(result);

        scanner.close();
    }
}