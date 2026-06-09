import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_456_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the line containing the matrix data
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");

        // Parse the input into a list of lists (matrix m)
        List<List<Integer>> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            // Ensure we handle the case where the input line might contain fewer than n*k elements, 
            // though based on Python logic, we assume the split tokens form the rows.
            // Since the Python code implies the entire line is split into N rows of K elements, 
            // we reconstruct the rows based on the split tokens.
            
            // A more robust way matching the Python list comprehension structure:
            // If the input line contains all numbers sequentially:
            if (i * tokens.length < tokens.length) {
                // This structure assumes the input line contains all numbers sequentially
                // and we need to slice them into rows of length K.
                // Since the Python code uses input().split() once for N rows, 
                // we must assume the input line contains N*K numbers.
                
                // Let's re-read the input handling based strictly on the Python structure:
                // Python: m = [[int(x) for x in input().split()] for i in range(n)]
                // This implies input().split() yields the elements for *one* row, and this is repeated N times.
                // This means the input must provide N separate lines, or the Python code is flawed/misinterpreted regarding standard input flow.
                
                // Given the ambiguity, we stick to the interpretation that the entire subsequent input line is processed:
                // If the input line is "1 5 2 8 3 7 4 6 9" (9 elements), and N=3, then K=3.
                
                // We will reconstruct the matrix based on the assumption that the input line contains all elements sequentially.
                
                // Since the Python code reads input() only once for the matrix, we must process the tokens sequentially.
                // We need to adjust how we read the input if we assume the standard competitive programming style where N lines follow N.
                
                // Let's assume the input is N lines following N, as is typical for matrix input, despite the Python structure suggesting otherwise.
                // If we strictly follow the Python structure (reading one line for M):
                // We need to read N lines of input, one for each row, if we want N rows of K elements.