import java.util.*;
import java.io.*;

public class atcoder_AGC013_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        List<Integer> a = new ArrayList<>();
        for (String s : A) {
            a.add(Integer.parseInt(s));
        }
        Collections.sort(a);
        int ans = 0;
        for (int i = 1; i < N - 1; i++) {
            if ((a.get(i - 1) < a.get(i) && a.get(i) > a.get(i + 1)) || (a.get(i - 1) > a.get(i) && a.get(i) < a.get(i + 1))) {
                ans++;
                i++;
            }
        }
        System.out.println(ans + 1);
    }
}