import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class s957164965 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read X and N (First line)
        if (!scanner.hasNextInt()) {
            return;
        }
        int X = scanner.nextInt();
        int N = scanner.nextInt();

        // Read p (Second line/remaining integers)
        List<Integer> pList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            pList.add(scanner.nextInt());
        }
        scanner.close();

        // Use a Set for efficient lookup of elements in p
        Set<Integer> pSet = new HashSet<>(pList);

        // candidates:
