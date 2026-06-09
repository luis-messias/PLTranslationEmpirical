import java.util.*;

public class atcoder_ABC145_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            indices.add(i);
        }
        
        List<Double> distances = new ArrayList<>();
        List<List<Integer>> permutations = generatePermutations(indices);
        
        for (List<Integer> perm : permutations) {
            double totalDistance = 0;
            for (int i = 0; i < N - 1; i++) {
                int f = perm.get(i);
                int t = perm.get(i + 1);
                double distance = Math.sqrt(Math.pow(x[t] - x[f], 2) + Math.pow(y[t] - y[f], 2));
                totalDistance += distance;
            }
            distances.add(totalDistance);
        }
        
        double result = 0;
        for (double d : distances) {
            result += d;
        }
        result /= distances.size();
        System.out.println(result);
    }
    
    private static List<List<Integer>> generatePermutations(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        permute(list, 0, result);
        return result;
    }
    
    private static void permute(List<Integer> list, int start, List<List<Integer>> result) {
        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            permute(list, start + 1, result);
            Collections.swap(list, start, i);
        }
    }
}
