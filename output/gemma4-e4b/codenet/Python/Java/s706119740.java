import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class s706119740 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        
        String line = scanner.nextLine();
        
        // Read, parse, and collect into an array of integers
        int[] candy = Stream.of(line.split("\\s+"))
                               .filter(s -> !s.isEmpty())
                               .mapToInt(Integer::parseInt)
                               .toArray();

        // Sort the array (equivalent to Python's sorted())
        Arrays.sort(candy);

        // Check the condition: candy[0] + candy[1] == candy[2]
        if (candy.length >= 3 && candy[0] + candy[1] == candy[2]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}