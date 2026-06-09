import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeforces_705_B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] w = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            w[i] = Integer.parseInt(input[i]);
        }
        int c = 2;
        for (int i : w) {
            if (i == 1) {
                System.out.println(c);
            } else if (i % 2 == 0) {
                c = 3 - c;
                System.out.println(c);
            } else {
                System.out.println(c);
            }
        }
    }
}