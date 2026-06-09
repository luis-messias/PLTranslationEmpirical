import java.util.Scanner;

public class codeforces_678_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line, split it by space, and parse the two integers
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        // Assuming input format is always two space-separated integers
        int vamshi = Integer.parseInt(parts[0]);
        int z = Integer.parseInt(parts[1]);
        
        // Calculate the result: ((vamshi / z) + 1) * z
        // Java's / operator performs integer division, matching Python's //
        int result = (int)((vamshi / z + 1) * z);
        
        System.out.println(result);
    }
}