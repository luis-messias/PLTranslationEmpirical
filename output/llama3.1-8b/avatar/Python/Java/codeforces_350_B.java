import java.util.*;

public class codeforces_350_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] t = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[n + 1];

        for (int i : a) {
            cnt[i]++;
        }

        for (int i = 1; i <= n; i++) {
            if (t[i] == 1) {
                List<Integer> crt = new ArrayList<>();
                int x = a[i];
                while (cnt[x] == 1) {
                    crt.add(x);
                    x = a[x];
                }
                if (crt.size() > ans.size()) {
                    ans.clear();
                    ans.addAll(crt);
                }
            }
        }

        Collections.reverse(ans);
        System.out.println(ans.size());
        System.out.print(ans.stream().map(String::valueOf).reduce((a1, a2) -> a1 + " " + a2).orElse(""));
    }
}