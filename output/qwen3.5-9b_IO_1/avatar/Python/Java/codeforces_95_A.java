import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class codeforces_95_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pya = scanner.nextInt();
        ArrayList<String> arre = new ArrayList<>();
        while (pya > 0) {
            pya--;
            arre.add(scanner.next().toLowerCase());
        }
        String oString = scanner.next();
        String lowString = oString.toLowerCase();
        String letter1 = scanner.next().substring(0).toLowerCase();
        String letter2 = letter1.toLowerCase().equals("a") ? "b" : "a";
        boolean[] valid = new boolean[oString.length()];
        Set<Integer> setcito = new HashSet<>();
        for (String x : arre) {
            int wat = 0;
            while (true) {
                int index = lowString.indexOf(x, wat);
                if (index < 0) {
                    break;
                }
                for (int i = index; i < index + x.length(); i++) {
                    setcito.add(i);
                }
                wat = index + 1;
            }
        }
        char[] oStringArray = oString.toCharArray();
        for (int i : setcito) {
            char letter = lowString[i].equals(letter1) ? letter2.charAt(0) : letter1.charAt(0);
            oStringArray[i] = Character.toLowerCase(oStringArray[i]) == Character.toLowerCase(letter) ? letter : Character.toUpperCase(letter);
        }
        for (char c : oStringArray) {
            System.out.print(c);
        }
        System.out.println();
    }
}
