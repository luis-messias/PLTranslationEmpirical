import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_469_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read max_level
        if (!scanner.hasNextInt()) {
            // Handle case where input might be missing or invalid, though usually assumed valid in competitive programming context
            return;
        }
        int maxLevel = scanner.nextInt();

        // Read x
        String xLine = scanner.nextLine();
        String[] xTokens = xLine.trim().split("\\s+");
        ArrayList<Integer> xList = new ArrayList<>();
        for (String token : xTokens) {
            if (!token.isEmpty()) {
                xList.add(Integer.parseInt(token));
            }
        }

        // Read y
        String yLine = scanner.nextLine();
        String[] yTokens = yLine.trim().split("\\s+");
        ArrayList<Integer> yList = new ArrayList<>();
        for (String token : yTokens) {
            if (!token.isEmpty()) {
                yList.add(Integer.parseInt(token));
            }
        }

        // x.pop(0) and y.pop(0)
        if (!xList.isEmpty()) {
            xList.remove(0);
        }
        if (!yList.isEmpty()) {
            yList.remove(0);
        }

        // x = set(x) and y = set(y)
        Set<Integer> xSet = new HashSet<>(xList);
        Set<Integer> ySet = new HashSet<>(yList);

        // Conditional logic
        if (xSet.contains(0)) {
            xSet.remove(0);
        } else if (ySet.contains(0)) {
            ySet.remove(0);
        }

        // z = x.union(y)
        Set<Integer> z = new HashSet<>(xSet);
        z.addAll(ySet);

        // Final check
        if (z.size() != maxLevel) {
            System.out.println("Oh, my keyboard!");
        } else {
            System.out.println("I become the guy.");
        }

        scanner.close();
    }
}