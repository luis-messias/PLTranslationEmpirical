import java.util.*;

public class atcoder_AGC029_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> A = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            A.add(Integer.parseInt(s));
        }
        Collections.sort(A, Collections.reverseOrder());

        int N = A.size();
        public static List<int[]> cut(List<int[]> array, int index) {
            if (index < 1) return new ArrayList<>();
            if (index <= array.get(0)[0]) return Arrays.asList(new int[]{index, array.get(0)[1]});
            for (int i = array.size() - 1; i > 0; i--) {
                if (array.get(i-1)[0] < index) {
                    List<int[]> result = new ArrayList<>(array.subList(0, i));
                    result.add(new int[]{index, array.get(i)[1]});
                    return result;
                }
            }
        }

        public static boolean isPossible(int K) {
            List<int[]> dp = Arrays.asList(new int[]{A.get(0), 0});
            for (int a : A.subList(1, N)) {
                if (a <= dp.get(dp.size() - 1)[0]) {
                    dp = cut(dp, a);
                } else {
                    dp.add(new int[]{a, 0});
                }
                boolean isAdded = false;
                for (int j = dp.size() - 1; j >= 0; j--) {
                    if (dp.get(j)[1] < K - 1) {
                        List<int[]> result = new ArrayList<>(Arrays.asList(dp.subList(0, j)));
                        int[] temp = {dp.get(j)[0], dp.get(j)[1] + 1};
                        result.add(temp);
                        if (temp[0] < a) {
                            result.add(new int[]{a, 0});
                        }
                        dp = result;
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) return false;
            }
            return true;
        }

        public static int bis(int x, int y) {
            if (y == x + 1) return y;
            else if (isPossible((x + y) / 2)) {
                return bis(x, (x + y) / 2);
            } else {
                return bis((x + y) / 2, y);
            }
        }

        System.out.println(bis(0, N));
    }
}