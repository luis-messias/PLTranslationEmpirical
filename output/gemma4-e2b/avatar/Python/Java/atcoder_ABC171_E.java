import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class atcoder_ABC171_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (though N is unused in the calculation)
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
        }

        // Read the list a
        // Read the rest of the line containing the numbers
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");

        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            // Handle case where the line might be empty after reading N
            return;
        }

        List<Integer> a = new java.util.ArrayList<>();
        for (String part : parts) {
            try {
                a.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {
                // Skip invalid parts if any
            }
        }

        // Calculate total = reduce(xor, a, 0)
        int total = 0;
        for (int x : a) {
            total ^= x;
        }

        // Calculate the result: " ".join(list(map(lambda ai: str(ai ^ total), a)))
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.size(); i++) {
            int xorResult = a.get(i) ^ total;
            result.append(xorResult);
            if (i < a.size() - 1) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }
}