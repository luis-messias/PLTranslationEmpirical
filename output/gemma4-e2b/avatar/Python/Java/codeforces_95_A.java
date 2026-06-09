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
        
        // 6. valid = [0 for i in range(len(oString))] (Unused, skipped for brevity)
        
        // 7. setcito = set()
        Set<Integer> setcito = new HashSet<>();

        // 8. Loop over arre
        for (String x : arre) {
            // if lowString.find(x) >= 0 :
            if (lowString.indexOf(x) != -1) {
                int wat = 0;
                // while True :
                while (true) {
                    // index = lowString.find(x