import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.Math;

public class s575946485 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Read 5 integers into array a
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        // 2. Initialize and populate the map (dic)
        Map<Integer, Integer> dic = new HashMap<>();
        
        for (int i = 0; i < 5; i++) {
            int currentNum = a[i];
            int lastDigit = currentNum % 10;
            int value;
            
            if (lastDigit == 0) {
                value = 0;
            } else {
                // Equivalent to int(str(a[i])[-1]) - 10
                value = lastDigit - 10;
            }
            dic.put(i, value);
        }

        // 3. Find min_num (the index corresponding to the minimum value)
        int minVal = Integer.MAX_VALUE;
        int minNum = -1;

        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            int index = entry.getKey();
            int value = entry.getValue();
            
            if (value < minVal) {
                minVal = value;
                minNum = index;
            }
        }

        // 4. Calculate sums and modify the map
        long aSum = 0;
        for (int num : a) {
            aSum += num;
        }

        // Pop the entry for min_num
        dic.remove(minNum);

        // Calculate the sum of remaining values in dic
        long remainingSum = 0;
        for (int value : dic.values()) {
            remainingSum += value;
        }

        // 5. Print the result: abs(sum(dic.values())) + a_sum
        long result = Math.abs(remainingSum) + aSum;
        System.out.println(result);
    }
}