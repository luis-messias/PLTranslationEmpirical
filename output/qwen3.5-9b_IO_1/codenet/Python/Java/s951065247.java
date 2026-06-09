import java.util.Scanner;

public class s951065247 {
    static int N, A, B, C;
    static int[] l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        l = new int[N];
        for (int i = 0; i < N; i++) {
            l[i] = sc.nextInt();
        }
        
        System.out.println(dfs(0, 0, 0, 0));
    }

    static int dfs(int cur, int a, int b, int c) {
        if (cur == N) {
            return Math.min(Math.min(a, b), c) > 0 ? Math.abs(A - a) + Math.abs(B - b) + Math.abs(C - c) - 30 : 1000000000;
        }
        
        int noAdd = dfs(cur + 1, a, b, c);
        int addA = dfs(cur + 1, a + l[cur], b, c) + 10;
        int addB = dfs(cur + 1, a, b + l[cur], c) + 10;
        int addC = dfs(cur + 1, a, b, c + l[cur]) + 10;
        
        return Math.min(Math.min(noAdd, addA), Math.min(addB, addC));
    }
}
