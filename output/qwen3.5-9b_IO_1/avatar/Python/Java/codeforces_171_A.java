import java.util.Scanner;

public class codeforces_171_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().trim();
        String b = scanner.nextLine().trim();
        
        int x = Math.max(a.length(), b.length());
        
        StringBuilder aPadded = new StringBuilder();
        StringBuilder bPadded = new StringBuilder();
        
        for (int i = 0; i < x; i++) {
            if (i < a.length()) {
                aPadded.append(a.charAt(i));
            } else {
                aPadded.append('0');
            }
        }
        
        for (int i = 0; i < x; i++) {
            if (i < b.length()) {
                bPadded.append(b.charAt(i));
            } else {
                bPadded.append('0');
            }
        }
        
        StringBuilder s = new StringBuilder();
        int c = 0;
        
        for (int i = 0; i < x; i++) {
            int digitA = aPadded.charAt(x - i - 1) - '0';
            int digitB = bPadded.charAt(x - i - 1) - '0';
            int d = digitA + digitB + c;
            
            if (d > 9) {
                s.append(d % 10);
                c = 1;
            } else {
                s.append(d);
                c = 0;
            }
        }
        
        if (c == 1) {
            s.append('1');
        }
        
        System.out.println(s.reverse().toString());
    }
}
