import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class s575946485 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = scanner.nextInt();
        }
        
        Map<Integer, Integer> dic = new HashMap<>();
        
        for (int i = 0; i < 5; i++) {
            String strA = String.valueOf(a[i]);
            int lastDigit = strA.charAt(strA.length() - 1) - '0';
            
            if (lastDigit == 0) {
                dic.put(i, 0);
            } else {
                dic.put(i, lastDigit - 10);
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        int minNum = -1;
        
        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            if (entry.getValue() < minVal) {
                minVal = entry.getValue();
                minNum = entry.getKey();
            }
        }
        
        dic.remove(minNum);
        
        int aSum = 0;
        for (int num : a) {
            aSum += num;
        }
        
        int dicSum = 0;
        for (int val : dic.values()) {
            dicSum += val;
        }
        
        System.out.println(Math.abs(dicSum) + aSum);
    }
}