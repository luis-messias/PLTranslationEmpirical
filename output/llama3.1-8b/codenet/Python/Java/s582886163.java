import java.util.Arrays;
import java.util.Scanner;

public class s582886163 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] capacityList = new int[5];
        for (int i = 0; i < 5; i++) {
            capacityList[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(capacityList);
        int bottleNeck = capacityList[0];
        System.out.println(4 + (N + bottleNeck - 1) / bottleNeck);
    }
}