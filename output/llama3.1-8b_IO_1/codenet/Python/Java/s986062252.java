import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s986062252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        String s = br.readLine();
        String t = br.readLine();

        int aa = gcd(n, m(inputs.length));
        int bb = lcm(n, m(inputs.length));
        int cc = aa / bb;

        for (int i = 0; i < aa; i++) {
            if (s.charAt((n / aa) * i) != t.charAt((m / aa) * i)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(bb);
    }

    public static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int m(int n) {
        String s = br.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.split(" ")[i]);
        }
        return arr[0];
    }
}
