import java.util.Scanner;

public class s993625131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        
        int count = 0;
        int record = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'A' || c == 'C' || c == 'G' || c == 'T') {
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