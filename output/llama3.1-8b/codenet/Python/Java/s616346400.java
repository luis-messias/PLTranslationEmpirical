import java.util.Scanner;

public class s616346400 {
    public static String atc_079a(String inputValue) {
        int n = 3;
        for (int i = 0; i < inputValue.length() - n + 1; i++) {
            for (int j = 1; j < n; j++) {
                if (inputValue.charAt(i) != inputValue.charAt(i + j)) {
                    break;
                }
                if (j == n - 1) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        System.out.println(atc_079a(inputValue));
    }
}