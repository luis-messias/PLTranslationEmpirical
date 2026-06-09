import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_116 {
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr, (x, y) -> {
            String binX = Integer.toBinaryString(x);
            String binY = Integer.toBinaryString(y);
            if (binX.length() != binY.length()) return Integer.compare(binX.length(), binY.length());
            int countX = 0;
            for (char c : binX.toCharArray()) {
                if (c == '1') countX++;
            }
            int countY = 0;
            for (char c : binY.toCharArray()) {
                if (c == '1') countY++;
            }
            return Integer.compare(countX, countY);
        });
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 4};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
