import java.util.HashMap;
import java.util.Scanner;

public class codeforces_518_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        HashMap<Character, Integer> freqs = new HashMap<>();
        HashMap<Character, Integer> freqt = new HashMap<>();
        int yay = 0;
        int whoops = 0;

        // Calculate frequencies for s
        for (char letra : s.toCharArray()) {
            freqs.put(letra, freqs.getOrDefault(letra, 0) + 1);
        }

        // Calculate frequencies for t
        for (char letra : t.toCharArray()) {
            freqt.put(letra, freqt.getOrDefault(letra, 0) + 1);
        }

        // Calculate yay (common characters overlap)
        // Iterate over characters present in s
        for (char letra : freqs.keySet()) {
            // Check if the character is also present in t
            if (freqt.containsKey(letra)) {
                int countS = freqs.get(letra);
                int countT = freqt.get(letra);
                int common = Math.min(countS, countT);
                yay += common;
            }
        }

        // The original Python logic for yay was iterative and complex. 
        // Let's re-implement the exact iterative logic for yay to ensure equivalence, 
        // although the simpler intersection logic above is mathematically equivalent for finding total common occurrences.
        // Reverting to the iterative structure for exact translation fidelity:
        
        // Reset yay and use the original iterative approach structure
        yay = 0;
        HashMap<Character, Integer> freqsCopy = new HashMap<>(freqs);
        HashMap<Character, Integer> freqtCopy = new HashMap<>(freqt);

        for (char letra : freqs.keySet()) {
            while (freqsCopy.get(letra) > 0 && freqtCopy.containsKey(letra) && freqtCopy.get(letra) > 0) {
                yay++;
                freqsCopy.put(letra, freqsCopy.get(letra) - 1);
                freqtCopy.put(letra, freqtCopy.get(letra) - 1);
            }
        }


        // Calculate whoops (case mismatches)
        whoops = 0;
        
        // Iterate over characters present in s (freqs)
        for (char letra : freqs.keySet()) {
            // We need a mutable copy of freqs counts for this loop, as the previous loop modified the conceptual counts.
            // Since the original Python code modifies freqs and freqt in place, we must ensure we are working with the original counts or a fresh copy if we want to reuse the structure.
            // Since the original code modifies freqs and freqt during the yay calculation, we must assume the subsequent whoops calculation operates on the modified state, or re-read the intent.
            // Given the structure, the intent is likely to check the remaining counts after yay calculation, but the Python code structure implies the yay calculation modifies the maps used for whoops.
            // Let's stick to the structure where we check the original counts if possible, or assume the maps are used as mutable counters.

            // Since the Python code modifies freqs and freqt during the yay calculation, we must use the modified state for whoops.
            
            // We need to re-calculate freqs and freqt if we want to use the original counts for whoops, or ensure the yay calculation doesn't destroy necessary information.
            // Given the complexity, let's assume the intent is to check the original character presence/counts for whoops, independent of the yay calculation's consumption.
            
            // Re-initialize maps for clarity if we want to calculate whoops based on original counts:
            HashMap<Character, Integer> freqsOriginal = new HashMap<>();
            HashMap<Character, Integer> freqtOriginal = new HashMap<>();
            
            for (char c : s.toCharArray()) freqsOriginal.put(c, freqsOriginal.getOrDefault(c, 0) + 1);
            for (char c : t.toCharArray()) freqtOriginal.put(c, freqtOriginal.getOrDefault(c, 0) + 1);
            
            // Recalculate yay based on original counts (simpler and safer interpretation)
            yay = 0;
            for (char letra : freqsOriginal.keySet()) {
                if (freqtOriginal.containsKey(letra)) {
                    yay += Math.min(freqsOriginal.get(letra), freqtOriginal.get(letra));
                }
            }
            
            // Calculate whoops based on original counts
            whoops = 0;
            for (char letraS : freqsOriginal.keySet()) {
                int countS = freqsOriginal.get(letraS);