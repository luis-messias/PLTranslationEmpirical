import java.util.*;

public class atcoder_ABC167_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] L = new int[N + 1];
        L[0] = -1;
        for (int i = 1; i <= N; i++) {
            L[i] = sc.nextInt();
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(1);
        
        Map<Integer, Integer> Hash = new HashMap<>();
        int x = 1;
        int t = -1;
        boolean flag = false;
        int ind = 0;
        
        for (int i = 0; i <= N; i++) {
            int ne = L[x];
            if (Hash.containsKey(ne)) {
                flag = true;
                t = Hash.get(ne);
                break;
            }
            path.add(ne);
            ind++;
            Hash.put(ne, ind);
            x = ne;
        }
        
        if (flag) {
            List<Integer> loop = new ArrayList<>();
            for (int i = t; i < path.size(); i++) {
                loop.add(path.get(i));
            }
            
            if (K < path.size()) {
                System.out.println(path.get(K));
            } else {
                K = K - path.size();
                K = K % loop.size();
                System.out.println(loop.get(K));
            }
        } else {
            System.out.println(path.get(K - 1));
        }
    }
}
