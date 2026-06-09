import java.util.Scanner;

public class s616346400 {

    public static String atc_079a(String input_value) {
        int n = 3;
        int L = input_value.length();

        // The loop range in Python: range(0, len(input_value) + 1 - n) 
        // corresponds to i <= L - n
        for (int i = 0; i <= L - n; i++) {
            // j runs from 1 to n-1 (1, 2)
            for (int j = 1; j < n; j++) {
                // Check if input_value[i] == input_value[i + j]
                if (input_value.charAt(i) != input_value.charAt(i + j)) {
                    break;
                }
                // If j == n - 1 (j == 2), we found three equal characters
                if (j == n - 1) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input_value = scanner.nextLine();
            System.out.println(atc_079a(input_value));
        }