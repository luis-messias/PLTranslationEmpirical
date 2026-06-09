import java.util.Scanner;
import java.util.regex.Pattern;

public class codeforces_617_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String a = scanner.nextLine();
        scanner.close();

        // Check if the string contains '1'
        if (!a.contains("1")) {
            System.out.println(0);
            return;
        }

        // 1. Strip leading/trailing '0's and spaces (equivalent to Python's strip("0 "))
        // Regex: ^[0 ]+|[0 ]+$ matches one or more '0' or ' ' at the start OR end.
        String strippedA = a.replaceAll("^[0 ]+|[0 ]+$", "");

        // If stripping results in an empty string, and we know '1' was present, 
        // this case is tricky. However, if '1' was present, strippedA must contain it 
        // unless the input was something like "010". If it was "010", strippedA is "1".
        if (strippedA.isEmpty()) {
             // This case should ideally not happen if '1' was present, 
             // but if it does, the logic implies the product calculation fails or results in 1.
             // Given the structure, if '1' is present, strippedA will contain it.
             // If strippedA is empty, it means the original string was only composed of '0's and spaces, 
             // which contradicts the check a.contains("1"). We proceed assuming valid input structure.
        }
        
        // 2. Split the string by '1'
        String[] parts = strippedA.split("1");

        // 3. Calculate the product
        long product = 1;
        for (String i : parts) {
            // Count '0's in the substring i
            int zeroCount = 0;
            for (char c : i.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
            }
            
            // Calculate value: zeroCount + 1
            long value = zeroCount + 1;
            
            // Multiply into the product
            product *= value;
        }

        System.out.println(product);
    }
}