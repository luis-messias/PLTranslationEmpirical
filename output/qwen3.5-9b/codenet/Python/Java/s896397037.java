import java.util.Arrays;
import java.util.Scanner;

public class s896397037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        
        if (sArray[0] == sArray[1] && sArray[0] != sArray[2] && sArray[2] == sArray[3]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}