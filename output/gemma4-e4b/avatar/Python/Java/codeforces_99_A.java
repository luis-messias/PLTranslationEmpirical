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
        int i = Character.getNumericValue(pStr.charAt(0));

        if (lastCharS == '9') {
            System.out.println("GOTO Vasilisa.");
        } else if (lastCharS != '9' && i < 5) {
            // Case 2: Print sStr as is
            System.out.println(sStr);
        } else {
            // Case 3: Increment sStr
            try {
                int num = Integer.parseInt(sStr);
                String result = String.valueOf(num + 1);
                System.out.println(result);
            } catch (NumberFormatException e) {
                // If sStr is not a valid integer, the behavior is undefined 
                // based on the original Python, but we handle it gracefully.
            }
        }
    }
}