import java.util.Scanner;

public class atcoder_ABC043_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // s = str(input())
        String s = scanner.nextLine();
        
        // my_str = ''
        StringBuilder my_str = new StringBuilder();
        
        // for c in s:
        for (char c : s.toCharArray()) {
            if (c == '0' || c == '1') {
                // my_str += c
                my_str.append(c);
            } else if (c == 'B' && my_str.length() != 0) {
                // my_str = my_str[ : len(my_str) - 1 ] (Remove the last character)
                my_str.deleteCharAt(my_str.length() - 1);
            }
        }
        
        // print(my_str)
        System.out.println(my_str.toString());
        
        scanner.close();
    }
}