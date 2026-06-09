import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class s240532461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N and L
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int L = scanner.nextInt();

        List<Integer> aji = new ArrayList<>();
        
        // Generate aji: L, L+1, ..., L+N-1
        for (int i = 1; i <= N; i++) {
            aji.add(L + i - 1);
        }

        if (aji.isEmpty()) {
            System.out.println(0);
            return;
        }

        // Find min and max for conditional logic
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int val : aji) {
            if (val < minVal) {
                minVal = val;
            }
            if (val > maxVal) {
                maxVal = val;
            }
        }

        if (minVal >= 0) {
            // if min(aji) >= 0: aji.pop(aji.index(min(aji)))
            int indexToRemove = aji.indexOf(minVal);
            if (indexToRemove != -1) {
                aji.remove(indexToRemove);
            }
        } else if (maxVal <= 0) {
            // elif max(aji) <= 0: aji.pop(aji.index(max(aji)))
            int indexToRemove = aji.indexOf(maxVal);
            if (indexToRemove != -1) {
                aji.remove(indexToRemove);
            }
        } else {
            // else: aji.pop(aji.index(min(aji,key=abs)))
            // Find the element with the minimum absolute value (closest to zero)
            int minAbs = Integer.MAX_VALUE;
            int indexToRemove = -1;

            for (int i = 0; i < aji.size(); i++) {
                int currentVal = aji.get(i);
                int absVal = Math.abs(currentVal);
                
                if (absVal < minAbs) {
                    minAbs = absVal;
                    indexToRemove = i;
                }
            }

            if (indexToRemove != -1) {
                aji.remove(indexToRemove);
            }
        }

        // Print the sum
        long sum = 0;
        for (int val : aji) {
            sum += val;
        }
        System.out.println(sum);
    }
}