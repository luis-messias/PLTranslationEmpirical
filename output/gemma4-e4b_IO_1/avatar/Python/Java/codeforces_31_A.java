import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_31_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read y (first integer input)
        if (!scanner.hasNextInt()) {
            System.out.println("-1");
            return;
        }
        int y = scanner.nextInt();

        // Read the remaining space-separated integers into the array
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        scanner.close();

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        int n = arr.length;

        // Translate the triple nested loop logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    // Condition check: arr[k] != arr[j] AND arr[k] != arr[i] AND arr[k] == arr[i] + arr[j]
                    if (arr[k] != arr[j] && arr[k] != arr[i] && arr[k] == arr[i] + arr[j]) {
                        // Print k + 1, j + 1, i + 1
                        System.out.println((k + 1) + " " + (j + 1) + " " + (i + 1));
                        return; // Exit the program immediately
                    }
                }
            }
        }
        
        // If no combination is found
        System.out.println("-1");
    }
}
