import java.util.Scanner;

public class codeforces_70_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Read the input string for splitting
        if (!scanner.hasNextLine