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

        // Calculate yay (common characters overlap) - Modifies freqs and freqt
        // Iterate over characters present in s
        for (char letra : freqs.keySet()) {
            // Check if the character is also present in t
            if (freqt.containsKey(letra)) {
                int countS = freqs.get(letra);
                int countT = freqt.get(letra);
                int common = Math.min(countS, countT);
                yay += common;
                
                // Decrement counts based on the common amount found
                freqs.put(letra, countS - common);
                freqt.put(letra, countT - common);
            }
        }

        // Calculate whoops (case mismatches) - Operates on the remaining counts in freqs and freqt
        whoops = 0;
        
        // Iterate over characters present in s (which now hold the remaining counts)
        for (char letra : freqs.keySet()) {
            // We only proceed if there are remaining occurrences in s
            if (freqs.get(letra) > 0) {
                
                // Check for lowercase in s matching uppercase in t
                if (Character.isLowerCase(letra)) {
                    char upper = Character.toUpperCase(letra);
                    if (freqt.containsKey(upper) && freqt.get(upper) > 0) {
                        whoops += 1;
                        freqs.put(letra, freqs.get(letra) - 1);
                        freqt.put(upper, freqt.get(upper) - 1);
                    }
                } 
                // Check for uppercase in s matching lowercase in t
                else if (Character.isUpperCase(letra)) {
                    char lower = Character.toLowerCase(letra);
                    if (freqt.containsKey(lower) && freqt.get(lower) > 0) {
                        whoops += 1;
                        freqs.put(letra, freqs.get(letra) - 1);
                        freqt.put(lower, freqt.get(lower) - 1);
                    }
                }
                // If no match found, the loop continues to the next character (Python's 'break' is implicitly handled by the structure if we don't explicitly break, but the Python code had a 'break' which implies stopping checks for that specific 'letra' if the first condition fails, which is not what the Python code implies. The Python code breaks the inner while loop, not the outer loop.)
                // Re-examining Python: the 'break' is inside the 'while' loop. If the 'if' fails, the 'while' loop terminates for that specific 'letra'.
            }
        }

        System.out.println(yay + " " + whoops);
