import java.util.Arrays;
import java.util.Scanner;

public class codeforces_581_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputArr = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        int mx = arr[arr.length - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(0, mx - arr[i] + 1);
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        System.out.println(Arrays.toString(ans).replaceAll("\\[|\\]|,", ""));
    }
}