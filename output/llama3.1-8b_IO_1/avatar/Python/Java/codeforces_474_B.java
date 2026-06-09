import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_474_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> L = new ArrayList<>();
        String inputStr = scanner.nextLine();
        int r = 1;
        for (String k : inputStr.split(" ")) {
            for (int i = 0; i < Integer.parseInt(k); i++) {
                L.add(r);
            }
            r++;
        }
        String inputStr2 = scanner.nextLine();
        for (String j : inputStr2.split(" ")) {
            System.out.println(L.get(Integer.parseInt(j) - 1));
        }
    }
}
