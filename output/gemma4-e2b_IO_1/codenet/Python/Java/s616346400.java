import java.util.Scanner;

public class s616346400 {

    public static String atc_079a(String input_value) {
        int n = 3;
        int L = input_value.length();

        // i iterates over the starting index. We need i + n - 1 < L, so i <= L - n.
        for (int i = 0; i <= L - n; i++) {
            // j iterates over the offset, from 1 to n-1 (1, 2)
            for (int j = 1; j < n; j++) {
                // Check if input_value[i] == input_value[i + j]
                if (input_value.charAt(i) != input_value.charAt(i + j)) {
                    break;
                }
                // If j == n - 1 (j=2), it means input_value[i] == input_value[i+1] == input_value[i+2]
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
        scanner.close();
    }
}
