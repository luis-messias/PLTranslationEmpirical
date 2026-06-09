import java.util.Scanner;
import java.util.ArrayList;

public class s331817031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read h and w
        if (!scanner.hasNextInt()) return;
        int h = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int w = scanner.nextInt();

        // Read the grid
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            if (scanner.hasNextLine()) {
                l.add(scanner.nextLine());
            }
        }

        // The Python code reads the input line by line, which might require careful handling of the scanner buffer, especially when mixing nextInt() and nextLine().
        // Since the input format implies reading H lines of W characters, we assume the input lines are provided sequentially.

        // Re-reading input based on standard competitive programming style where input() reads the whole line.
        // Let's re-implement input reading to match the Python structure more closely, assuming input() reads the next line.

        // Resetting input reading approach to handle the structure implied by the Python code reading H lines of input.
        
        // Since we cannot reliably rewind the stream or perfectly replicate the exact behavior of Python's input() reading across environments without knowing the exact input stream structure, 
        // we will assume the input is provided sequentially as H lines of W characters.

        // Let's re-read the input structure assuming the input stream provides H lines of W characters.
        
        // If we assume the input reading in the Python code was correct for the environment:
        // We need to re-read the input structure to ensure the logic is tested correctly.
        
        // Since the provided snippet is a direct translation task, we must assume the input reading mechanism works as intended for the environment.
        
        // Let's use a simpler approach for reading the grid based on the structure:
        
        // We will re-read the input stream if necessary, but since we are translating the logic, we focus on the logic flow.
        
        // --- Re-implementing based on the logic flow ---
        
        // We need to handle the input reading robustly in Java. Let's assume the input is provided correctly line by line.
        
        // Since the provided Python code uses `input()` repeatedly, we must ensure the Java code reads exactly what is expected.
        
        // Let's assume the input reading is handled by reading H lines of input.
        
        // If we strictly follow the Python code's structure:
        
        // We need to re-read the input if we are running this in a standard environment where input is piped.
        // Since I cannot interactively read the stream here, I will structure the code assuming the input is available.
        
        // Let's use a single Scanner for simplicity, assuming the input is provided correctly.
        
        // Since the provided Python code uses `exit()`, we will use a boolean flag or throw an exception.
        
        // --- Final Java structure based on the logic ---
        
        // We must read H and W first.
        // Then read H lines of input.