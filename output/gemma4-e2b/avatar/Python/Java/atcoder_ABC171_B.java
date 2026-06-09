import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC171_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line to get n and k
        if (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String[] parts1 = line1.split(" ");
            if (parts1.length >= 2) {
                // n, k = map(int, input().split())
                // We read n and k, but they are not used in the final calculation based on the structure, 
                // only the subsequent input is used for the sum.
                // We still read them to match the Python structure.
                // int n = Integer.parseInt(parts1[0]); // n is unused in the calculation logic below
                int k = Integer.parseInt(parts1[1]);

                // Read the second line for the list of numbers
                if (scanner.hasNextLine()) {
                    String line2 = scanner.nextLine();
                    String[] parts2 = line2.split(" ");
                    List<Integer> numbers = new ArrayList<>();
                    
                    for (String part : parts2) {
                        if (!part.isEmpty()) {
                            numbers.add(Integer.parseInt(part));
                        }
                    }

                    // sum(sorted(list(map(int, input().split())))[:k]
                    
                    // 1.