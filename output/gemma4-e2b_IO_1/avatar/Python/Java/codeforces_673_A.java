import java.util.Scanner;

public class codeforces_673_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first input)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the array elements (assuming they follow immediately)
        // Since the Python code reads the array from the next line, we read the rest of the line.
        // If the input is 1\n15, nextLine() will read "15".
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            
            if (parts.length > 0) {
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i]);
                }

                if (arr.length > 0) {
                    if (arr[0] > 15) {
                        System.out.println(15);
                    } else {
                        boolean found = false;
                        for (int i = 1; i
