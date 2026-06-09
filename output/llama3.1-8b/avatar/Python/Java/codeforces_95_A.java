import java.util.*;

public class codeforces_95_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pya = Integer.parseInt(scanner.nextLine());
        List<String> arre = new ArrayList<>();
        while (pya > 0) {
            pya--;
            arre.add(scanner.nextLine().toLowerCase());
        }
        String oString = scanner.nextLine();
        String lowString = oString.toLowerCase();
        char letter1 = scanner.next().charAt(0);
        char letter2 = 'b';
        if (Character.toLowerCase(letter1) != 'a') {
            letter2 = 'a';
        }
        boolean[] valid = new boolean[oString.length()];
        Set<Integer> setcito = new HashSet<>();
        for (String x : arre) {
            if (lowString.indexOf(x) >= 0) {
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
        }
        char[] oStringArray = oString.toCharArray();
        for (Integer i : setcito) {
            char letter = Character.toLowerCase(letter1);
            if (Character.isLowerCase(oStringArray[i])) {
                oStringArray[i] = letter;
            } else {
                oStringArray[i] = Character.toUpperCase(letter);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : oStringArray) {
            sb.append(c).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}