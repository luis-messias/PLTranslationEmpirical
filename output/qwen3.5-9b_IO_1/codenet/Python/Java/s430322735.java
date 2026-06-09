import java.util.*;

public class s430322735 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            char[] chars = input.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            lst.add(sorted);
        }
        Collections.sort(lst);
        lst.add("end");
        String pre = "";
        int tmp_cnt = 0;
        int cnt = 0;
        for (String i : lst) {
            if (i.equals(pre)) {
                tmp_cnt++;
            } else {
                cnt += sumRange(tmp_cnt + 1);
                tmp_cnt = 0;
            }
            pre = i;
        }
        System.out.println(cnt);
    }
    
    private static int sumRange(int n) {
        return n * (n + 1) / 2;
    }
}
