import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class s430322735 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n
        if (!scanner.hasNextInt()) {
            // Handle case where n might not be provided, though usually guaranteed in context
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading n

        // 2. Read and process strings
        ArrayList<String> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            
            // Sort characters
            char[] chars = input.toCharArray();
            Arrays.sort(chars);
            String sortedString = new
