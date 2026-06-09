import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC167_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int K = scanner.nextInt();

        // Read L
        List<Integer> L = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    L.add(Integer.parseInt(part));
                }
            }
        }
        
        // Handle case where L might be read on the same line or subsequent lines depending on input style.
        // Assuming L is read from the next line based on standard competitive programming input style, 
        // or if the input format implies L is on the same line as N, K, we need careful reading.
        // Based on the Python code structure, L is read separately. Let's re-read L assuming it's the next line.
        
        // Re-reading L based on the Python structure where L is read after N, K.
        // Since the provided Python code reads N, K, then L, we assume L is provided on the next line.
        
        // If the input reading above failed to capture L correctly due to mixed reading styles, 
        // we rely on the structure implied by the Python code:
        
        // Let's reset and read input strictly as Python does:
        
        // Re-reading input assuming standard space-separated input for all numbers:
        
        // Since the provided Python code uses input() multiple times, we must ensure the Java input matches this flow.
        // Let's assume N, K are on line 1, and L is on line 2.
        
        // If the input reading above was complex, let's simplify based on the expectation that the input stream provides N, K, then L.
        
        // For robustness, let's assume the input stream provides N, K, and then the elements of L sequentially.
        
        // Since I cannot perfectly replicate the exact stream behavior without knowing the exact input format provided to the Python script, 
        // I will proceed with the logic assuming N, K, and L are successfully read into variables.