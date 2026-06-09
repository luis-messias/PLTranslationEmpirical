import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class codeforces_95_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read pya
        if (!scanner.hasNextInt()) {
            return;
        }
        int pya = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading pya

        // 2. Read arre
        java.util.List<String> arre = new java.util.ArrayList<>();
        for (int i = 0; i < pya; i++) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                arre.add(input.toLowerCase());
            }
        }

        // 3. Read oString
        String oString = "";
        if (scanner.hasNextLine()) {
            oString = scanner.nextLine();
        }

        // 4. Read letter1 input
        String letter1Input = "";
        String letter1 = "";
        if (scanner.hasNextLine()) {
            letter1Input = scanner.nextLine();
            if (!letter1Input.isEmpty()) {
                letter1 = String.valueOf(letter1Input.charAt(0)).toLowerCase();
            }
        }

        // 5. Determine letter2
        char letter2Char;
        if (letter1.equals("a")) {
            letter2Char = 'b';
        } else {
            letter2Char = 'a';
        }
        String letter2 = String.valueOf(letter2Char);

        // 6. Initialization
        Set<Integer> setcito = new HashSet<>();
        String lowString = oString.toLowerCase();
        
        // 7. Processing arre (Finding indices)
        for (String x : arre) {
            if (lowString.contains(x)) {
                int wat = 0;
                while (wat < lowString.length()) {
                    int index = lowString.indexOf(x, wat);
                    if (index < 0) {
                        break;
                    }
                    
                    // Add indices
                    for (int i = 0; i < x.length(); i++) {
                        setcito.add(index + i);
                    }
                    
                    // Move past the found occurrence
                    wat = index + 1;
                }
            }
        }

        // 8. Final Transformation
        char[] oStringChars = oString.toCharArray();
        
        for (int i : setcito) {
            char originalChar = oStringChars[i];
            
            // Determine replacement letter
            String replacement;
            if (lowString.charAt(i) != letter1.charAt(0)) {
                replacement = letter1;
            } else {
                replacement = letter2;
            }
            
            // Determine case of replacement
            char replacementChar;
            if (Character.isLowerCase(originalChar)) {
                replacementChar = Character.toLowerCase(replacement.charAt(0));
            } else {
                replacementChar = Character.toUpperCase(replacement.charAt(0));