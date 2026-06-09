import java.util.Scanner;

public class codeforces_474_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        int r = 1;
        for (String k : inputStr.split(" ")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Integer.parseInt(k); i++) {
                sb.append(r).append(",");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
            r++;
        }
        String inputStr2 = scanner.nextLine();
        for (String j : inputStr2.split(" ")) {
            System.out.println(L.get(Integer.parseInt(j) - 1));
        }
    }
}