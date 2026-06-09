import java.util.Scanner;
import java.util.Arrays;

public class codeforces_31_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        String[] arrStr = scanner.nextLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            if (!arrStr[i].isEmpty()) { // Check if string is not empty before parsing to integer
                arr[i] = Integer.parseInt(arrStr[i]);
            } else {
                arr[i] = 0; // Assign a default value for empty strings
            }
        }
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] != arr[j] && arr[k] != arr[i] && arr[k] == arr[i] + arr[j]) {
                        System.out.println((k + 1) + " " + (j + 1) + " " + (i + 1));
                        found = true;
                        return;
                    }
                }
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}
