import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC142_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        Pair[] A = new Pair[input.length];
        for (int i = 0; i < input.length; i++) {
            A[i] = new Pair(i + 1, Integer.parseInt(input[i]));
        }
        Arrays.sort(A, (a, b) -> a.getValue() - b.getValue());
        int[] A__ = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            A__[i] = A[i].getPosition();
        }
        for (int i = 0; i < A__.length - 1; i++) {
            System.out.print(A__[i] + " ");
        }
        System.out.println(A__[A__.length - 1]);
    }

    private static class Pair implements Comparable<Pair> {
        int position;
        int value;

        public Pair(int position, int value) {
            this.position = position;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }

        public int getPosition() {
            return position;
        }

        public int getValue() {
            return value;
        }
    }
}