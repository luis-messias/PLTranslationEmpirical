import java.util.*;

public class codeforces_274_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int num = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);

        String[] input2 = scanner.nextLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (String s : input2) {
            arr.add(Integer.parseInt(s));
        }

        Set<Integer> different = new HashSet<>();
        Collections.sort(arr);

        int temp = 0;
        for (int x : arr) {
            if ((x % k != 0 || !different.contains(x / k)) && x >= k) {
                different.add(x);
            }
            temp = Math.max(different.size(), temp);
        }

        System.out.println(temp);
    }
}
