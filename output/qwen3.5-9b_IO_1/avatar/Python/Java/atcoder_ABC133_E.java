import java.util.*;

public class atcoder_ABC133_E {
    static ArrayList<Integer>[] graph;
    static long mod = 1000000007;
    static int N, K;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a - 1].add(b - 1);
            graph[b - 1].add(a - 1);
        }
        
        System.out.println(dfs(0, -1, K));
    }
    
    static long dfs(int fro, int to, int f) {
        long
