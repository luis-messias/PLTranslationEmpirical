import java.util.Arrays;
import java.util.Scanner;

public class s896397037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        
        char[] s = line.toCharArray();
        Arrays.sort(s);
        
        if (s[0] == s[1] && s[0] != s[2] && s[2] == s[3]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}