import java.util.ArrayList;
import java.util.Scanner;

public class codeforces_672_A {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 1; i < 371; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                temp /= 10;
                count++;
            }
            if (count == 1) {
                li.add(i);
            } else if (count == 2) {
                StringBuilder sb = new StringBuilder();
                int q = i;
                while (q != 0) {
                    int x = q % 10;
                    q /= 10;
                    sb.append(x);
                }
                String s = sb.reverse().toString();
                for (int j = 0; j < s.length(); j++) {
                    li.add(Character.getNumericValue(s.charAt(j)));
                }
            } else if (count == 3) {
                StringBuilder sb = new StringBuilder();
                int q = i;
                while (q != 0) {
                    int x = q % 10;
                    q /= 10;
                    sb.append(x);
                }
                String s = sb.reverse().toString();
                for (int j = 0; j < s.length(); j++) {
                    li.add(Character.getNumericValue(s.charAt(j)));
                }
            }
        }
        li.remove(li.size() - 1);
        li.remove(li.size() - 1);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println(li.get(n - 1));
    }
}
