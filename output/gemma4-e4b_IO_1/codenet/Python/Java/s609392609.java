import java.util.Scanner;
import java.util.Arrays;

public class s609392609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n (unused variable)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Consume the rest of the line after reading n
        scanner.nextLine(); 

        // 2. Read t (array of integers)
        String lineT = "";
        if (scanner.hasNextLine()) {
            lineT = scanner.nextLine();
        }
        
        int[] t = new int[0];
        if (!lineT.trim().isEmpty()) {
            String[] tokens = lineT.trim().split("\\s+");
            t = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                t[i] =
