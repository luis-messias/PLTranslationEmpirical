import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_95_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. pya = int(input())
        if (!scanner.hasNextInt()) return;
        int pya = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // 2. Read pya lines into arre
        ArrayList<String> arre = new ArrayList<>();
        for (int i = 0; i < pya; i++) {
            if (scanner.hasNextLine()) {
                arre.add(scanner.nextLine().toLowerCase());
            }
        }

        // 3. oString = input()
        if (!scanner.hasNextLine()) return;
        String oString = scanner.nextLine();
        String lowString = oString.toLowerCase();

        // 4. letter1 = input()[0].lower()
        if (!scanner.hasNextLine()) return;
        String letter1Input = scanner.nextLine();
        String letter1 = "";
        if (!letter1Input.isEmpty()) {
            letter1 = letter1Input.toLowerCase().substring(0, 1);
        }
        
        // 5. letter2 = 'a' if letter1.lower() != 'a' else 'b'
        char letter1Lower = letter1.toLowerCase().charAt(0);
        char letter2;
        if (letter1Lower != 'a') {
            letter2 = 'a';
        } else {
            letter2 = 'b';
        }
        
        // 6. valid = [0 for i in range(len(oString))] (Skipped)
        
        // 7. setcito = set()
        Set<Integer> setcito = new HashSet<>();

        // 8. Loop over arre
        for (String x : arre) {
            // if lowString.find(x) >= 0 :
            if (lowString.indexOf(x) != -1) {
                int wat = 0;
                // while True :
                while (true) {
                    // index = lowString.find(x, wat)
                    int index = lowString.indexOf(x, wat);
                    if (index == -1) {
                        break;
                    }
                    // for i in range(index, index + len(x)):
                    for (int i = index; i < index + x.length(); i++) {
                        setcito.add(i);
                    }
                    wat = index + 1;
                }
            }
        }

        // oString = list(oString)
        // We will modify oString directly as a mutable structure
        String[] oStringChars = oString.toCharArray();

        // 11. Iterate through setcito
        for (int i : setcito) {
            char letter;
            // letter = letter1 if lowString[i] != letter1 else letter2
            char charAtI = lowString.charAt(i);
            if (charAtI != letter1) {
                letter = letter1;
            } else {
                letter = letter2;
            }
            
            // oString[i] = letter if oString[i].islower() else letter.upper()
            if (Character.isLowerCase(oStringChars[i])) {
                oStringChars[i] = Character.toLowerCase(letter
