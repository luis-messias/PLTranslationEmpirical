import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class codeforces_682_B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] l = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            l[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(l);
        int c = 1;
        for (int i : l) {
            if (i > c) {
                c++;
            }
        }
        System.out.println(c + 1);
    }
}