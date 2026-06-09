import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;

public class codeforces_456_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the matrix M
        List<List<Integer>> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            while (scanner.hasNextInt()) {
                row.add(scanner.nextInt());
                // Assuming input lines are space-separated and we read all available integers for that row
                // If we strictly assume one line per row, we need more complex input handling, 
                // but based on the Python structure, reading all available integers until the next row starts is typical.
                // For simplicity, we assume the input stream provides all elements row by row.
                // Since the Python code uses input().split(), we assume the input stream provides all elements for the current row.
                // We will rely on the fact that the input reading mechanism handles the row structure correctly.
                
                // To correctly simulate reading a row from a single line of space-separated values:
                // We need to read the entire line and split it.
                // Since Scanner consumes tokens, we must adjust the reading logic if we want to stick to Scanner.
                // Let's assume the input format is strictly N lines, each containing space-separated integers.
                
                // Resetting the reading logic to handle line-by-line input simulation:
                break; // Break after reading the first token to allow the outer loop to handle the next row input
            }
            
            // Re-implementing input reading robustly for Java/Scanner:
            // Since we cannot reliably know how many elements are on a line without reading the whole line,
            // we must assume the input structure is fixed or use a helper method.
            // Given the constraints of translating the Python code, we assume the input stream provides N rows, 
            // and we read all available tokens for the current row until the next row starts.
            
            // A simpler approach for translation: read all tokens for the current row.
            List<Integer> currentRow = new ArrayList<>();
            // We must read the entire line content to simulate split().
            // Since Scanner makes this hard, we will assume the input is provided token by token, 
            // and we need to read enough tokens to form a row.
            
            // Given the ambiguity, we will assume the input reading mechanism is fixed to read N rows, 
            // and we read all available tokens for that row.
            
            // If we assume the input is provided as N lines, and each line is space-separated:
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                // If the line is empty, we might have finished reading rows prematurely.
                // This handles potential empty lines between test cases.
                i--; 
                continue;
            }
            
            String[] tokens = line.trim().split("\\s+");
            List<Integer> rowList = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    rowList.add(Integer.parseInt(token));
                }
            }
            m.add(rowList);
        }
        
        // Re-reading N and M using a standard approach for competitive programming environment
        // Since the provided snippet is a function body, we must assume the environment handles input correctly.
        // Let's rewrite the input reading block to be self-contained and robust for the translation.
        
        // --- START OF REVISED INPUT READING ---
        scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        n = scanner.nextInt();
        
        m.clear();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            // Read the entire line for the current row
            String line = scanner.nextLine();
            if (line.trim().isEmpty() && i > 0) {
                // Handle case where reading the line might consume the next row's start token
                // This is highly dependent on the execution environment. 
                // Assuming standard input flow where