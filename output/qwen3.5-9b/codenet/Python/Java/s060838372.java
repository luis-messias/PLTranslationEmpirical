import java.util.Scanner;

public class s060838372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();
        
        char[] sArray = S.toCharArray();
        
        if (sArray[K-1] == 'A') {
            sArray[K-1] = 'a';
        } else if (sArray[K-1] == 'B') {
            sArray[K-1] = 'b';
        } else {
            sArray[K-1] = 'c';
        }
        
        System.out.println(new String(sArray));
    }
}