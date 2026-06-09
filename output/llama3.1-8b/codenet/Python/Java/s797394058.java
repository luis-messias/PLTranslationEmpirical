import java.util.*;

public class s797394058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Integer> N_list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            N_list.add(i + 1);
        }

        List<int[]> n = new ArrayList<>();
        for (Integer x : N_list) {
            for (Integer y : N_list) {
                for (Integer z : N_list) {
                    int[] temp = {x, y, z};
                    n.add(temp);
                }
            }
        }

        System.out.println(n.size());
    }
}