import java.util.Scanner;

public class codeforces_369_B {
    public static int[] get_nums(int num, int t) {
        if (num == 0) {
            return new int[0];
        }
        int[] result = new int[num];
        int base = t / num;
        int remainder = t % num;
        
        for (int i = 0; i < num; i++) {
            if (i < remainder) {
                result[i] = base + 1;
            } else {
                result[i] = base;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int sa = scanner.nextInt();
        int sk = scanner.nextInt();
        
        int[] ans1 = get_nums(k, sk);
        int[] ans2 = get_nums(n - k, sa - sk);
        
        int[] ans = new int[ans1.length + ans2.length];
        System.arraycopy(ans1, 0, ans, 0, ans1.length);
        System.arraycopy(ans2, 0, ans, ans1.length, ans2.length);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
            if (i < ans.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
