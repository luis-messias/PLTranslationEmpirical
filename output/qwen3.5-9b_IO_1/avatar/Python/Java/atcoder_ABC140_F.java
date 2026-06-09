import java.util.*;
import java.io.*;

public class atcoder_ABC140_F {
    static int I() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            return 0;
        }
    }
    
    static List<Integer> LI() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                return new ArrayList<>();
            }
            String[] parts = line.trim().split("\\s+");
            List<Integer> result = new ArrayList<>();
            for (String part : parts) {
                if (!part.isEmpty()) {
                    result.add(Integer.parseInt(part));
                }
            }
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
    public static void main(String[] args) {
        int N = I();
        List<Integer> S = LI();
        Collections.sort(S, Collections.reverseOrder());
        
        boolean[] flag = new boolean[S.size()];
        for (int i = 0; i < S.size(); i++) {
            flag[i] = true;
        }
        
        List<Integer> cur = new ArrayList<>();
        cur.add(S.get(0));
        flag[0] = false;
        
        for (int i = 0; i < N; i++) {
            int j = 0;
            int jM = cur.size();
            for (int k = 0; k < S.size(); k++) {
                if (flag[k] && S.get(k) < cur.get(j)) {
                    cur.add(S.get(k));
                    j++;
                    flag[k] = false;
                    if (j == jM) {
                        break;
                    }
                }
            }
            if (j < jM) {
                System.out.println("No");
                return;
            }
            Collections.sort(cur, Collections.reverseOrder());
        }
        
        System.out.println("Yes");
    }
}
