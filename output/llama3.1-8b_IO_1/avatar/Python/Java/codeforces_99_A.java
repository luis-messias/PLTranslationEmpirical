import java.util.Scanner;

public class codeforces_99_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\.");
        char[] firstPart = parts[0].toCharArray();
        char[] secondPart = parts[1].toCharArray();
        int index = Character.getNumericValue(secondPart[0]);
        if (firstPart[firstPart.length - 1] == '9') {
            System.out.println("GOTO Vasilisa.");
        } else if (index < 5 && firstPart[firstPart.length - 1] != '9') {
            String result = new String(firstPart);
            System.out.println(result);
        } else {
            StringBuilder sb = new StringBuilder(new String(firstPart));
            int incrementedValue = Integer.parseInt(sb.toString()) + 1;
            System.out.println(incrementedValue);
        }
    }
}
