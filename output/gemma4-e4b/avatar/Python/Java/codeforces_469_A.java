import java.util.*;
import java.util.stream.Collectors;

public class codeforces_469_A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read max_level
        if (!scanner.hasNextInt()) {
            return;
        }
        int maxLevel = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after maxLevel

        // 2. Read x elements
        String lineX = scanner.nextLine();
        List<Integer> listX = parseLine(lineX);

        // 3. Read y elements
        String lineY = scanner.nextLine();
        List<Integer> listY = parseLine(lineY);

        // --- Processing ---

        // 1. Pop(0)
        if (!listX.isEmpty()) {
            listX.remove(0);
        }
        if (!listY.isEmpty()) {
            listY.remove(0);
        }

        // 2. Convert to Sets
        Set<Integer> xSet = new HashSet<>(listX);
        Set<Integer> ySet = new HashSet<>(listY);

        // 3. Handle 0 (discard 0 if present)
        if (xSet.contains(0)) {
            xSet.remove(0);