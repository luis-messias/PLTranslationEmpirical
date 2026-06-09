import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_106_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Store input data (S, R, H, C)
        // We use an ArrayList of arrays or objects to store the input
        ArrayList<int[]> inputArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                int S = scanner.nextInt();
                int R = scanner.nextInt();
                int H = scanner.nextInt();
                int C = scanner.nextInt();
                inputArray.add(new int[]{S, R, H, C});
            }
        }

        // Step 2: Find outdated items
        Set<int[]> outdatedSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if item i is strictly smaller than item j in S, R, and H
                // input_array[i][0] < input_array[j][0] (S)
                // input_array[i][1] < input_array[j][1] (R)
                // input_array[i][2] < input_array[j][2] (H)
                
                int Si = inputArray.get(i)[0];
                int Ri = inputArray.get(i)[1];
                int Hi = inputArray.get(i)[2];
                
                int Sj = inputArray.get(j)[0];
                int Rj = inputArray.get(j)[1];
                int Hj = inputArray.get(j)[2];

                if (Si < Sj && Ri < Rj && Hi < Hj) {
                    // Item i is outdated because item j dominates it
                    outdatedSet.add(inputArray.get(i));
                }
            }
        }

        // Step 3: Find the minimum cost among non-outdated items
        int minimumCost = 100000;
        int inputNumber = 0;

        for (int i = 0; i < n; i++) {
            int[] currentItem = inputArray.get(i);
            int cost = currentItem[3];

            // Check if current_item is NOT in outdated
            // Since we stored int arrays in the set, we need to check if the exact array object exists.
            // Note: HashSet uses object references for equality.
            boolean isOutdated = false;
            for (int[] outdatedItem : outdatedSet) {
                if (java.util.Arrays.equals(currentItem, outdatedItem)) {
                    isOutdated = true;
                    break;
                }
            }

            if (!isOutdated && cost < minimumCost) {
                minimumCost = cost;
                inputNumber = i + 1;
            }
        }

        System.out.println(inputNumber);
        scanner.close();
    }
}