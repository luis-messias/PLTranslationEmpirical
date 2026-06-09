import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class codeforces_274_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read num and k from the first line
        if (!scanner.hasNextInt()) {
            return;
        }
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        // Read all remaining integers into the array list (arr)
        List<Integer> arrList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arrList.add(scanner.nextInt());
        }
        
        scanner.close();

        // Sort the array
        Collections.sort(arrList);

        // Initialization
        Set<Integer> different = new HashSet<>();
        int temp = 0;

        // Iterate through the sorted elements
        for (int x : arrList) {
            // Python condition: (x % k != 0 or not x // k in different)
            // In Java, integer division (x / k) performs floor division for positive numbers.
            boolean conditionMet = (x % k != 0) || !different.contains(x / k);
            
            if (conditionMet) {
                different.add(x);
            }
            
            // temp = max(len(different), temp)
            temp = Math.max(different.size(), temp);
        }

        System.out.println(temp);
    }
}