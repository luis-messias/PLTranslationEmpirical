import java.util.Scanner;

public class atcoder_ABC158_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        boolean containsA = false;
        boolean containsB = false;
        
        for (char c : s.toCharArray()) {
            if ("AB".indexOf(c) != -1) {
                if (c == 'A') containsA = true;
                else if (c == 'B') containsB = true;
            }
        }

        String result = "Yes" + System.lineSeparator() + "No";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("AB".indexOf(c) != -1 && containsA && containsB)
                continue;
            
            result += c;
        }
        
        System.out.println(result.trim());
    }
}
