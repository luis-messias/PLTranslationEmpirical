import java.util.*;

public class s787811177 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] pair = new int[2];
            pair[0] = sc.nextInt();
            pair[1] = sc.nextInt();
            ls.add(pair);
        }
        
        ls.sort((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
        
        int taka = 0;
        int aoki = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (i % 2 == 0) {
                taka += ls.get(i)[0];
            } else {
                aoki += ls.get(i)[1];
            }
        }
        
        System.out.println(taka - aoki);
    }
}
