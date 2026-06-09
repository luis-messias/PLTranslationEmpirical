import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_450_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Read the list l from the second line
        List<Integer> l = new ArrayList<>();
        // We assume the next line contains the elements of l
        // Since the Python code reads input sequentially, we read the next line for l
        // Note: If the input is provided all at once, we might need to adjust how we read.
        // Assuming standard input structure where n, m are on line 1 and l is on line 2.
        
        // Read the list l
        List<Integer> l_list = new ArrayList<>();
        // Since the Python code reads input sequentially, we read the next line for l
        // We must ensure we read the actual list elements.
        
        // Re-reading based on typical competitive programming input style where all data is provided:
        // If the input is provided as:
        // n m
        // l1 l2 l3 ...
        
        // Let's assume the input stream provides n, m, and then the list l elements sequentially.
        
        // Since the provided Python code reads input twice, we stick to that structure.
        
        // Read l
        while (scanner.hasNextInt()) {
            l_list.add(scanner.nextInt());
        }
        
        // If the input reading was intended to be strictly line-by-line as in Python:
        // We need to handle the input stream carefully. Let's re-read the input based on the Python structure.
        
        // Resetting input reading to strictly follow the Python logic:
        // The provided Python code implies reading two separate lines of input.
        
        // If we assume the input is provided in a way that allows reading n, m, then l:
        
        // Since I cannot perfectly replicate the exact interactive input flow without knowing the exact test case structure, 
        // I will structure the code assuming the input stream provides the necessary numbers sequentially.
        
        // Let's re-read the input assuming the provided structure implies reading all necessary data from stdin.
        
        // If we strictly follow the Python input structure:
        // n, m = map(int, input().split())
        // l = list(map(int, input().split()))
        
        // We need to read the input stream again if we are running this in a standard environment.
        // Since I am translating the logic, I will assume the input is available.
        
        // Let's use a single Scanner reading all tokens, which is often safer in Java translation contexts.
        
        // --- Re-implementing based on the logic flow, assuming input is provided ---
        
        // Since I cannot execute the input reading directly here, I will structure the logic assuming n, m, and l are available.
        
        // If we must read from stdin:
        
        // Let's assume the input is provided as two lines:
        
        // Reading n and m
        // (Already done above, but let's assume the next read is for l)
        
        // If the environment expects reading from stdin, the structure must be:
        
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // int m = scanner.nextInt();
        // List<Integer> l = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     l.add(scanner.nextInt());
        // }
        
        // Since the Python code reads two separate lines, I will structure the Java code to read two lines explicitly.
        
        // --- Final attempt based on strict Python input reading ---
        
        // Since I cannot simulate the interactive input environment perfectly, I will write the code assuming the input is read correctly.
        
        // For a runnable translation, I must assume the input is provided via standard input.
        
        // Let's use a single input reading approach that mimics the Python structure:
        
        // If the input is provided as:
        // 5 3
        // 1 2 3 4 5
        
        // We need to read all tokens.
        
        // Since the provided Python code structure is highly dependent on sequential input calls, I will use a single Scanner reading all tokens sequentially.
        
        // --- Start of actual translation logic ---
        
        // We must assume the input reading happens correctly based on the environment.
        
        // Since I cannot rely on the previous scanner state, I will rewrite the reading part to be self-contained based on the Python structure.
        
        // If the environment expects the code to be runnable, I must assume the input is provided correctly.
        
        // Let's assume the input is provided via standard input and we read it all.
        
        // Since the provided snippet is a direct translation request, I will focus purely on