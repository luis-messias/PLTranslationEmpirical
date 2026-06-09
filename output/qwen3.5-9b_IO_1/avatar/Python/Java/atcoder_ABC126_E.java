import java.util.*;
import java.io.*;

public class atcoder_ABC126_E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edge.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int X = sc.nextInt() - 1;
            int Y = sc.nextInt() - 1;
            edge.get(X).add(Y);
            edge.get(Y).add(X);
        }
        
        boolean[] used = new boolean[N];
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                ans++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                used[i] = true;
                
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int nextnode : edge.get(node)) {
                        if (!used[nextnode]) {
                            used[nextnode] = true;
                            queue.offer(nextnode);
                        }
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}
