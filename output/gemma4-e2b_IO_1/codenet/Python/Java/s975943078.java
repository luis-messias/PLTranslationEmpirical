import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class s975943078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and K
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st = new StringTokenizer(line1);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Read array A
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer stA = new StringTokenizer(line2);
        
        // A elements are transformed: (a % K) - 1
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(stA.nextToken());
            // A[i] = (a % K) - 1
            A[i] = (a % K) - 1;
        }

        // sum_A[i] stores prefix sum up to A[
