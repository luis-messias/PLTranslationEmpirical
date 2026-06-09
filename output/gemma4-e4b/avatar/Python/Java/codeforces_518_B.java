import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_518_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Assuming input provides two lines for s and t
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();

        // 1. Frequency Counting
        Map<Character, Integer> freqs = new HashMap<>();
        Map<Character, Integer> freqt = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            freqt.put(c, freqt.getOrDefault(c, 0) + 1);
        }

        int yay = 0;
        int whoops = 0;

        // 2. Calculating yay (Exact Matches)
        // We iterate over a copy of the keyset because we modify the values.
        for (char letra : freqs.keySet()) {
            while (freqs.get(letra) > 0 && freqt.containsKey(letra) && freqt.get(letra) > 0) {
                yay++;
                freqs.put(letra, freqs.get(letra) - 1);
                freqt.put(letra, freqt.get(letra) - 1);
            }
        }

        // 3. Calculating whoops (Case-Insensitive Matches)
        // We iterate over the keyset of freqs again.
        for (char letra : freqs.keySet()) {
            while (freqs.get(letra) > 0) {
                boolean matched = false;
                
                // Check lowercase match (if current char is lowercase)
                if (Character.isLowerCase(letra)) {
                    char upperCaseChar = Character.toUpperCase(letra);
                    if (freqt.containsKey(upperCaseChar) && freqt.get(upperCaseChar) > 0) {
                        whoops++;
                        freqs.put(letra, freqs.get(letra) - 1);
                        freqt.put(upperCaseChar, freqt.get(upperCaseChar) - 1);
                        matched = true;
                    }
                } 
                // Check uppercase match (if current char is uppercase)
                else if (Character.isUpperCase(letra)) {
                    char lowerCaseChar = Character.toLowerCase(letra);
                    if (freqt.containsKey(lowerCaseChar) && freqt.get(lowerCaseChar) > 0) {
                        whoops++;
                        freqs.put(letra, freqs.get(letra) - 1);
                        freqt.put(lowerCaseChar, freqt.get(lowerCaseChar) - 1);
                        matched = true;
                    }
                }
                
                // If no match was found for the current character instance, break the while loop
                if (!matched) {
                    break;
                }
            }
        }

        // 4. Output
        System.out.println(yay + " " + whoops);
    }
}