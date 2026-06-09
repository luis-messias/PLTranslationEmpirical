import java.util.Scanner;
import java.util.Deque;

public class atcoder_ABC140_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> inputParser = new java.util.LinkedList<>();
        while (true) {
            String data = scanner.nextLine();
            for (String number : data.split(" ")) {
                if (!number.isEmpty()) {
                    inputParser.add(number);
                }
            }
            if (inputParser.size() == 0) {
                break;
            }
        }

        int N = Integer.parseInt(inputParser.removeFirst());
        int K = Integer.parseInt(inputParser.removeFirst());
        String S = inputParser.removeFirst();

        int segCnt = 0;
        for (int i = 0; i < N - 1; i++) {
            if (!S.substring(i, i + 1).equals(S.substring(i + 1, i + 2))) {
                segCnt++;
            }
        }

        int curHappy = N - 1 - segCnt;
        if (2 * K >= segCnt) {
            System.out.println(N - 1);
        } else {
            System.out.println(curHappy + 2 * K);
        }
    }
}