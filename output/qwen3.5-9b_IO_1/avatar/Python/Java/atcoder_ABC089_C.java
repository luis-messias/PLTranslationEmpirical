import java.util.*;
import java.io.*;

public class atcoder_ABC089_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = sc.next();
        }
        
        String[] march = {"M", "A", "R", "C", "H"};
        int[] march_lis = new int[5];
        
        for (String s : S) {
            char c = s.charAt(0).toUpperCase();
            for (int i = 0; i < march.length; i++) {
                if (march[i].equals(String.valueOf(c))) {
                    march_lis[i]++;
                    break;
                }
            }
        }
        
        long ans = 0;
        for (int i = 0; i < march.length; i++) {
            for (int j = i + 1; j < march.length; j++) {
                for (int k = j + 1; k < march.length; k++) {
                    ans += (long) march_lis[i] * march_lis[j] * march_lis[k];
                }
            }
        }
        
        System.out.println(ans);
    }
}
