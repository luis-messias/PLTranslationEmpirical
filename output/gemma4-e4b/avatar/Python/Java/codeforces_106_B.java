import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Item {
    int S, R, H, C;

    public Item(int S, int R, int H, int C) {
        this.S = S;
        this.R = R;
        this.H = H;
        this.C = C;
    }

    // Must override equals and hashCode for correct Set functionality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return S == item.S && R == item.R && H == item.H && C == item.C;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(S, R, H, C);
    }
}

public class codeforces_106_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read input_array
        ArrayList<Item> inputArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                break;
            }
            int S = scanner.nextInt();
            int R = scanner.nextInt();
            int H = scanner.nextInt();
            int C = scanner.nextInt();
            inputArray.add(new Item(S, R, H, C));
        }
        
        scanner.close();

        // Identify outdated items
        Set<Item> outdated = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            Item itemI = inputArray.get(i);
            for (int j = 0; j < n; j++) {
                Item itemJ = inputArray.get(j);
                
                // Check if itemI is outdated by itemJ
                if (itemI.S < itemJ.S && itemI.R < itemJ.R && itemI.H < itemJ.H) {
                    outdated.add(itemI);
                    // Once found outdated, we can break the inner loop for item i
                    break; 
                }
            }
        }

        // Find minimum cost non-outdated item
        int minimumCost = 100000; // Initial value based on Python code
        int inputNumber = 0;

        for (int i = 0; i < n; i++) {
            Item currentItem = inputArray.get(i);
            int cost = currentItem.C;

            // Check if currentItem is NOT outdated AND cost is less than minimumCost
            if (!outdated.contains(currentItem) && cost < minimumCost) {
                minimumCost = cost;
                inputNumber = i + 1; // 1-based index
            }
        }

        System.out.println(inputNumber);
    }
}