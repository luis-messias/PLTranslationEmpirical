import java.util.Scanner;

public class codeforces_514_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        StringBuilder st = new StringBuilder();

        if (ip.length() != 1) {
            if (ip.charAt(0) == '9') {
                st.append('9');
                ip = ip.substring(1);
            }
            for (char c : ip.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if (digit > 4) {
                    st.append(9 - digit);
                } else {
                    st.append(c);
                }
            }
        } else {
            st.append(ip);
        }

        System.out.println(Integer.parseInt(st.toString()));
    }
}
