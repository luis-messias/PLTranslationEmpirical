import java.util.*;

public class s240532461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        
        ArrayList<Integer> aji = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            aji.add(L + i - 1);
        }
        
        if (!aji.isEmpty()) {
            int minVal = Collections.min(aji);
            if (minVal >= 0) {
                aji.remove((Integer) minVal);
            } else if (Collections.max(aji) <= 0) {
                aji.remove((Integer) Collections.max(aji));
            } else {
                int minAbs = Integer.MAX_VALUE;
                int minAbsIndex = -1;
                for (int i = 0; i < aji.size(); i++) {
                    int abs = Math.abs(aji.get(i));
                    if (abs < minAbs) {
                        minAbs = abs;
                        minAbsIndex = i;
                    }
                }
                aji.remove(minAbsIndex);
            }
        }
        
        int sum = 0;
        for (int val : aji) {
            sum += val;
        }
        System.out.println(sum);
    }
}
