import java.util.Scanner;

public class s993625131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] S = s.toCharArray();

        int count = 0;
        int record = 0;

        for (int i = 0; i < S.length; i++) {
            char currentChar = S[i];
            if (currentChar == 'A' || currentChar == 'C' || currentChar == 'G' || currentChar == 'T') {
                count++;
            } else {
                if (count > record) {
                    record = count;
                }
                count = 0;
            }
        }

        if (count > record) {
            record = count;
        }

        System.out.println(record);
    }
}