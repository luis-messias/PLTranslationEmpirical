import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class s546174362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int M = scanner.nextInt();

        // Read the array A
        // Read the rest of the line/input for A
        // Since the Python code reads the next line for A, we read the next line.
        // Note: The Python input reading style implies reading all remaining integers on the next line.
        
        // We need to read all remaining integers from the input stream.
        // Since the exact structure of the input stream is ambiguous without context, 
        // we read the next line and parse the numbers.
        
        // Reading the rest of the input stream for A
        // We assume the input stream continues with the elements of A.
        
        // A robust way to handle the Python input style where the rest of the line is read:
        // Read the rest of the line after N and M, or read the next line entirely.
        
        // Let's re-read the input based on standard competitive programming style where all numbers follow.
        // Since the Python code reads N, M, then the rest of the line for A, we read the next line.
        
        // If the input was provided as:
        // 3 2
        // 1 2 3 4 5
        
        // We need to read all remaining tokens.
        
        // Re-reading input based on the structure:
        // N, M are read. Then the rest of the line is A.
        
        // Let's assume the input stream is structured such that we read N, M, and then the elements of A.
        
        // Since the provided Python code uses map(int, input().split()) twice, 
        // we read N and M, then read the array A elements.
        
        // To handle the input stream correctly, we read the next line for A.
        
        // We must handle the case where the input stream might be tricky. 
        // Let's assume the input is provided sequentially.
        
        // Reading A elements (assuming they are on the next line)
        // We need to read the entire line containing A elements.
        
        // Since we already read N and M, the next input line contains A.
        
        // We will use a new Scanner or handle the remaining input carefully.
        
        // Let's reset and read everything assuming standard sequential input:
        
        // If we read N and M, the next line contains A.
        
        // Since the provided code snippet is self-contained, we rely on the input stream state.
        
        // Let's re-implement input reading to match the Python style precisely:
        
        // If we assume the input is provided exactly as shown:
        // N M
        // A1 A2 ...
        
        // We need to read the next line for A.
        
        // Since the provided snippet is a single block, I will assume the input stream provides N, M, and then the elements of A sequentially.
        
        // Let's re-read the input assuming all numbers are provided sequentially.
        
        // If we stick to the provided structure:
        // N, M = read line 1
        // A = read line 2
        
        // We must ensure the Scanner reads correctly across lines.
        
        // Let's assume the input is provided on two lines.
        
        // Reading A elements from the next line:
        String lineA = scanner.nextLine();
        String[] aTokens = lineA.trim().split("\\s+");
        
        if (aTokens.length == 0) {
            // Handle case where A might be empty if input reading failed
            return;
        }
        
        int[] A = new int[aTokens.length];
        for (int i = 0; i < aTokens.length; i++) {
            A[i] = Integer.parseInt(aTokens[i]);
        }

        // Sort A
        Arrays.sort(A);

        // --- Core Logic Translation ---
        
        // The Python code uses list indexing and modification. We use an array for efficiency in Java.
        
        int[] currentA = A.clone(); // Work with a mutable copy
        
        while (M > 0) {
            // A[-1] //= 2
            currentA[currentA.length - 1] /= 2;
            M--;
            
            int i = -2; // Index relative to the end (A[-2])
            
            // Inner loop: while M and (-N<=i and A[i]>=A[-1]):
            while (M > 0 && i >= -N && currentA[i] >= currentA[currentA.length - 1]) {
                // A[i] //= 2