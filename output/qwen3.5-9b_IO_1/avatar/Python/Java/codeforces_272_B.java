import java.util.*;

public class codeforces_272_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");
            int[] sequence = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                sequence[i] = Integer.parseInt(input[i]);
            }
            System.out.println(nPairsWithCommonFX(sequence));
        }
    }
    
    public static int nPairsWithCommonFX(int[] sequence) {
        Map<Integer, List<Integer>> storage = new HashMap<>();
        List<Integer> FXs = new ArrayList<>();
        
        for (int value : sequence) {
            int y = f(value);
            if (!storage.containsKey(y)) {
                storage.put(y, new ArrayList<>());
                FXs.add(y);
            }
            storage.get(y).add(value);
        }
        
        int sum1 = 0;
        int sum2 = 0;
        for (int y : FXs) {
            int count = storage.get(y).size();
            sum1 += count * count;
            sum2 += count;
        }
        
        return (sum1 - sum2) / 2;
    }
    
    public static int f(int n) {
        int y = 1;
        while (n != 1) {
            if (n % 2 != 0) {
                y++;
            }
            n /= 2;
        }
        return y;
    }
}
