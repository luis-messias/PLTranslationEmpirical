import java.util.Scanner;

public class s060838372 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] parts = line1.split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        String s = scanner.nextLine();
        char[] sArray = s.toCharArray();

        if (sArray[K - 1] == 'A') {
            sArray[K - 1] = 'a';
        } else if (sArray[K - 1] == 'B') {
            sArray[K - 1] = 'b';
        } else {
            sArray[K - 1] = 'c';
        }

        System.out.println(new String(sArray));
    }
}