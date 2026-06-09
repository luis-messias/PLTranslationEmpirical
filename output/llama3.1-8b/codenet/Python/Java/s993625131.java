import java.util.Scanner;

public class s993625131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int count = 0;
        int record = 0;
        for (int i = 0; i < S.length(); i++) {
            if ("ACGT".indexOf(S.charAt(i)) != -1) {
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