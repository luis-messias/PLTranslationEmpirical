import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class s575946485 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read 5 integers into array a
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            if (scanner.hasNextInt()) {
                a[i] = scanner.nextInt();
            } else {
                // Handle case where input might be missing, though typically assumed present
                return; 
            }
        }
        scanner.close();

        Map<Integer, Integer> dic = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            int currentNum = a[i];
            int lastDigit = currentNum % 10;
            
            // Check if the last digit is 0
            if (lastDigit == 0) {
                dic.put(i, 0);
            } else {
                // Calculate (last_digit - 10)
                dic.put(i, lastDigit - 10);
            }
        }

        // Find min_num: the index corresponding to the minimum value in dic
        int minVal = Integer.MAX_VALUE;
        int minNum = -1;

        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            if (entry.getValue() < minVal) {
                minVal = entry.getValue();
                minNum = entry.getKey();
            }
        }

        // Calculate a_sum
        long aSum = 0;
        for (int x : a) {
            aSum += x;
        }

        // Remove the entry corresponding to min_num
        dic.remove(minNum);

        // Calculate the final result: abs(sum(dic.values()) + a_sum)
        long dicSum = dic.values().stream().mapToLong(Integer::longValue).sum();
        
        long result = Math.abs(dicSum + aSum);
        
        System.out.println(result);
    }
}