import java.util.Arrays;
import java.util.Scanner;

public class s430322735 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] lst = new String[n];
        for (int i = 0; i < n; i++) {
            String st = sortString(scanner.nextLine());
            lst[i] = st;
        }
        Arrays.sort(lst);
        String end = "end";
        int cnt = 0;
        int tmpCnt = 0;
        String pre = "";
        for (int i = 0; i < n; i++) {
            if (!lst[i].equals(pre)) {
                if (pre != "") {
                    cnt += calculateSum(tmpCnt + 1);
                }
                tmpCnt = 0;
            }
            tmpCnt++;
            pre = lst[i];
        }
        if (pre.equals(end)) {
            cnt += calculateSum(tmpCnt);
        } else {
            cnt += calculateSum(tmpCnt + 1);
        }
        System.out.println(cnt);
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static int calculateSum(int n) {
        return (n * (n + 1)) / 2;
    }
}