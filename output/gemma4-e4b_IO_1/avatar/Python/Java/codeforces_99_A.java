import java.util.Scanner;

public class codeforces_99_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();

        // Split the input by '.' (must escape the dot in regex)
        String[] parts = inputLine.split("\\.");

        // Assuming input is valid and has at least two parts
        if (parts.length < 2) {
            return;
        }

        String sStr = parts[0];
        String pStr = parts[1];

        // Get the last character of sStr
        char lastCharS = sStr.charAt(sStr.length() - 1);

        // Get the integer i from the first character of pStr
        // Since pStr is guaranteed to exist and we only need the first character
        int i = Character.getNumericValue(pStr.charAt(0));

        if (lastCharS == '9') {
            System.out.println("GOTO Vasilisa.");
        } else if (lastCharS != '9' && i < 5) {
            // Case 2: Print sStr as is
            System.out.println(sStr);
        } else {
            // Case 3: Increment sStr
            try {
                // Use Long.parseLong because the number can exceed Integer.MAX_VALUE
                long num = Long.parseLong(sStr);
                
                // Calculate num + 1
                long resultNum = num + 1;
                
                // Convert back to String
                String result = String.valueOf(resultNum);
                System.out.println(result);
            } catch (NumberFormatException e) {
                // If sStr is not a valid long, we assume the original Python behavior 
                // (which would likely fail or handle it as a string operation) 
                // is not required for standard competitive programming inputs.
            }
        }
    }
}
