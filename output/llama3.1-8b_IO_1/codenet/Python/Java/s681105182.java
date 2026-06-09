import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s681105182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] aStr = br.readLine().split(" ");
        int[] aLi = new int[aStr.length];
        for (int i = 0; i < aStr.length; i++) {
            aLi[i] = Integer.parseInt(aStr[i]);
        }
        Arrays.sort(aLi);

        int n = aLi[aLi.length - 1];

        long dif = Long.MAX_VALUE;
        long prevDif = dif;
        int r = 0;
        for (int i = 0; i < aLi.length - 1; i++) {
            int a = aLi[i];
            dif = Math.min(Math.abs(n / 2 - a), dif);
            if (dif != prevDif) {
                r = a;
                prevDif = dif;
            }
        }

        System.out.println(n + " " + r);
    }
}
