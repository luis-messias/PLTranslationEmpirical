import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC151_A {
    public static boolean debug = false;

    public static void log(String text) {
        if (debug) {
            System.out.println(text);
        }
    }

    public static String[] parseInput(String linesAsString) {
        debug = true;
        String[] lines = linesAsString.split("\n");
        return Arrays.copyOfRange(lines, 1, lines.length - 1);
    }

    public static String solve(char c) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        int i = a.indexOf(c);
        return a.charAt(i + 1) + "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char c = input.charAt(0);
        String result = solve(c);
        System.out.println(result);
    }
}