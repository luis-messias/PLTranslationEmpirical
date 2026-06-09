import java.util.Scanner;

public class atcoder_ABC151_A {
    static boolean debug = false;
    
    static void log(String text) {
        if (debug) {
            System.out.println(text);
        }
    }
    
    static char[] parseInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        char c = parts[0].charAt(0);
        return new char[]{c};
    }
    
    static char solve(char c) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        int i = a.indexOf(c);
        return a.charAt(i + 1);
    }
    
    public static void main(String[] args) {
        char[] result = parseInput();
        char c = result[0];
        char resultChar = solve(c);
        System.out.print(resultChar);
    }
}
