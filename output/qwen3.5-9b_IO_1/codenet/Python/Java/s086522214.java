import java.util.*;
import java.io.*;

public class s086522214 {
    // 素因数を並べる
    public static List<Integer> primeDecomposition(int n) {
        List<Integer> table = new ArrayList<>();
        int i = 2;
        while (i * i <= n) {
            while (n % i == 0) {
                n /= i;
                table.add(i);
            }
            i++;
        }
        if (n > 1) {
            table.add(n);
        }
        return table;
    }
    
    // 桁数を吐く
    public static List<Integer> digit(int i) {
        if (i > 0) {
            List<Integer> result = new ArrayList<>();
            result.addAll(digit(i / 10));
            result.add(i % 10);
            return result;
        } else {
            return new ArrayList<>();
        }
    }
    
    public static int getNearestValueIndex(List<Integer> list, int num) {
        int minDiff = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            int diff = Math.abs(list.get(i) - num);
            if (diff < minDiff) {
                minDiff = diff;
                idx = i;
            }
        }
        return idx;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Working code at the end
        String S = sc.next();
        String[] T = S.split("/");
        
        int date = Integer.parseInt(T[1] + T[2]);
        if (date <= 430) {
            System.out.println("Heisei");
        } else {
            System.out.println("TBD");
        }
    }
}
