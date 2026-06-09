import java.util.*;

public class s706119740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] candy = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            candy[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(candy);
        System.out.println(candy[0] + candy[1] == candy[2] ? "Yes" : "No");
    }
}