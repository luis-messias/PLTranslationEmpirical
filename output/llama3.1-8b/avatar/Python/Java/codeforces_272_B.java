import java.util.*;

public class codeforces_272_B {
    public static int main() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        return nPairsWithCommonFX(Arrays.stream(input).mapToInt(Integer::parseInt).toArray());
    }

    public static int nPairsWithCommonFX(int[] sequence) {
        Map<Integer, List<Integer>> storage = new HashMap<>();
        Set<Integer> FXs = new HashSet<>();

        for (int value : sequence) {
            int y = f(value);
            if (!storage.containsKey(y)) {
                storage.put(y, new ArrayList<>(Arrays.asList(value)));
                FXs.add(y);
            } else {
                storage.get(y).add(value);
            }
        }

        int sumOfSquares = 0;
        int sumOfCounts = 0;

        for (int y : FXs) {
            sumOfSquares += storage.get(y).size() * storage.get(y).size();
            sumOfCounts += storage.get(y).size();
        }

        return (sumOfSquares - sumOfCounts) / 2;
    }

    public static int f(int n) {
        int y = 1;
        while (n != 1) {
            if (n % 2 != 0) {
                y += 1;
            }
            n /= 2;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(main());
    }
}