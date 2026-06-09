import java.util.*;

public class atcoder_ABC150_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        Set<Integer> numSet = new HashSet<>();
        for (String s : scanner.nextLine().split(" ")) {
            numSet.add(Integer.parseInt(s));
        }
        
        Set<Integer> twoTimesSet = new HashSet<>();
        for (int i : numSet) {
            int j = 1;
            while (j < 30 && i % 2 == 0) {
                i /= 2;
                j++;
            }
            if (i % 2 != 0) {
                twoTimesSet.add(j);
                break;
            }
        }
        
        if (twoTimesSet.size() != 1) {
            System.out.println(0);
        } else {
            int[] numList = new int[numSet.size()];
            int index = 0;
            for (int i : numSet) {
                numList[index++] = i;
            }
            
            int lcm = numList[0];
            for (int i = 1; i < numList.length; i++) {
                lcm = lcm * numList[i] / gcd(lcm, numList[i]);
            }
            
            System.out.println((n - lcm / 2) / lcm + 1);
        }
    }
    
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}