import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class codeforces_469_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLevel = scanner.nextInt();
        
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();
        
        // Read x values, skip the first one
        for (int i = 0; i < maxLevel; i++) {
            if (i == 0) {
                scanner.nextInt(); // Skip first element
            } else {
                x.add(scanner.nextInt());
            }
        }
        
        // Read y values, skip the first one
        for (int i = 0; i < maxLevel; i++) {
            if (i == 0) {
                scanner.nextInt(); // Skip first element
            } else {
                y.add(scanner.nextInt());
            }
        }
        
        // Remove 0 if present in x
        if (x.contains(0)) {
            x.remove(0);
        }
        // Remove 0 if present in y (but not in x)
        else if (y.contains(0)) {
            y.remove(0);
        }
        
        // Union of x and y
        Set<Integer> z = new HashSet<>(x);
        z.addAll(y);
        
        if (z.size() != maxLevel) {
            System.out.println("Oh, my keyboard!");
        } else {
            System.out.println("I become the guy.");
        }
    }
}
