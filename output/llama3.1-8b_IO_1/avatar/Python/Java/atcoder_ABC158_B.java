import java.io.BufferedReader;
import java.io.InputStreamReader;

public class atcoder_ABC158_B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        String[] parts = input.split(" ");
        int A = Integer.parseInt(parts[1]);
        int B = Integer.parseInt(parts[2]);

        long mod = (long) 1e9 + 7;
        long ans = 0;
        long rep = N / (A + B);
        ans += rep * A;
        long res = N - rep * (A + B);
        ans += Math.min(res, A);

        System.out.println(ans);
    }
}
