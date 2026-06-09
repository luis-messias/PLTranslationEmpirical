import java.util.Scanner;

public class codeforces_32_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '.') {
                result.append('0');
            } else {
                // Original Python logic increments i here
                i++;
                
                // Check s[i] (which is the character at the new index i)
                //