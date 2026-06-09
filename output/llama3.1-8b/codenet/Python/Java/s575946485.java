import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s575946485 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(scanner.nextLine());
        }

        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            if (String.valueOf(a[i]).endsWith("0")) {
                dic.put(i, 0);
            } else {
                dic.put(i, Integer.parseInt(String.valueOf(a[i]).substring(String.valueOf(a[i]).length() - 1)) - 10);
            }
        }

        int minNum = getMinKey(dic);
        int aSum = 0;
        for (int i : a) {
            aSum += i;
        }
        dic.remove(minNum);

        System.out.println(Math.abs(getSum(dic.values())) + aSum);
    }

    private static int getMinKey(Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .min((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    private static int getSum(Iterable<Integer> iterable) {
        int sum = 0;
        for (Integer i : iterable) {
            sum += i;
        }
        return sum;
    }
}