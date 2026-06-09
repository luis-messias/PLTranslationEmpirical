import java.util.Scanner;

public class codeforces_99_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line l
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String l = scanner.nextLine();
        
        // l = l.split('.')
        String[] parts = l.split("\\.");
        
        // s is the first part (l[0])
        String s_str = parts[0];
        
        // p is the second part (l[1])
        String p_str = parts[1];
        
        // i = int(p[0])
        // p_str.charAt(0) gets the first character of the second part
        int i = Character.getNumericValue(p_str.charAt(0));
        
        // Check s[len(s) - 1]
        char lastSChar = s_str.charAt(s_str.length() - 1);
        
        if (lastSChar == '9') {
            System.out.println("GOTO Vasilisa.");
        } else if (lastSChar != '9' && i < 5) {
            // s = "".join(s)
