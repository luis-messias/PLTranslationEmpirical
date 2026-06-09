import java.util.*;

public class codeforces_106_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> inputArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int[] item = new int[4];
            for (int j = 0; j < 4; j++) {
                item[j] = Integer.parseInt(parts[j]);
            }
            inputArray.add(item);
        }

        Set<int[]> outdated = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inputArray.get(i)[0] < inputArray.get(j)[0] && inputArray.get(i)[1] < inputArray.get(j)[1] && inputArray.get(i)[2] < inputArray.get(j)[2]) {
                    outdated.add(inputArray.get(i));
                }
            }
        }

        int minimumCost = 100000;
        int inputNumber = 0;

        for (int i = 0; i < n; i++) {
            int[] currentItem = inputArray.get(i);
            if (!outdated.contains(currentItem) && currentItem[3] < minimumCost) {
                minimumCost = currentItem[3];
                inputNumber = i + 1;
            }
        }

        System.out.println(inputNumber);
    }
}