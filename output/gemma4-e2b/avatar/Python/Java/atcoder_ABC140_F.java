import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC140_F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I() equivalent: Read N
        String lineN = br.readLine();
        if (lineN == null) return;
        int N = Integer.parseInt(lineN.trim());

        // LI() equivalent: Read the list of numbers
        String lineS = br.readLine();
        if (lineS == null) return;
        StringTokenizer st = new StringTokenizer(lineS);
        
        List<Integer> S = new ArrayList<>();
        while (st.hasMoreTokens()) {
            S.add(Integer.parseInt(st.nextToken()));
        }

        // S = sorted(LI(), reverse=True)
        Collections.sort(S, Collections.reverseOrder());

        // flag = [True] * len(S)
        boolean[] flag = new boolean[S.size()];
        for (int i = 0; i < S.size(); i++) {
            flag[i] = true;
        }

        // cur = []
        List<Integer> cur = new ArrayList<>();

        // cur.append(S[0])
        if (!S.isEmpty()) {
            cur.add(S.get(0));
            flag[0] = false;
        }

        // Main loop: for i in range(N)
        for (int i = 0; i < N; i++) {
            // j = 0
            int j = 0;
            // jM = len(cur)
            int jM = cur.size();

            // Inner loop: for k in range(len(S))
            for (int k = 0; k < S.size(); k++) {
                // if flag[k] and S[k] < cur[j]:
                if (flag[k] && S.get(k) < cur.get(j)) {
                    // cur.append(S[k])
                    cur.add(S.get(k));
                    j++;
                    // flag[k] = False
                    flag[k] = false;
                    
                    // if j == jM: break
                    if (j == jM) {
                        break;
                    }
                }
            }

            // else block attached to the inner for loop (if loop completes without break)
            // In Python, the 'else' belongs to the inner loop. If the inner loop finishes normally (without break), 
            // the 'else' executes.
            boolean found = false;
            if (j == jM) {
                found = true;
            }
            
            if (!found) {
                System.out.println("No");
                return;
            }

            // cur.sort(reverse=True)
            Collections.sort(cur, Collections.reverseOrder());
        }

        // return "Yes"
        System.out.println("Yes");
    }
}