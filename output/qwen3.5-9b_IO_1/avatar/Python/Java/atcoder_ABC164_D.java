import java.util.Scanner;

public class atcoder_ABC164_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l = 2019;
        
        int[] m = new int[l + 1];
        m[0] = 1;
        int a = 0;
        int r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char e = s.charAt(s.length() - 1 - i);
            int digit = e - '0';
            a = (a + digit * (int)Math.pow(10, i)) % l;
            r += m[a];
            m[a]++;
        }
        
        System.out.println(r);
    }
}
