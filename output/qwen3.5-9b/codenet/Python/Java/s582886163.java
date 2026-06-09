import java.util.Scanner;
import java.util.Arrays;

public class s582886163 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] capacity_list = new int[5];
        for (int i = 0; i < 5; i++) {
            capacity_list[i] = scanner.nextInt();
        }
        Arrays.sort(capacity_list);
        int bottle_neck = capacity_list[0];
        System.out.println(4 + (N + bottle_neck - 1) / bottle_neck);
    }
}